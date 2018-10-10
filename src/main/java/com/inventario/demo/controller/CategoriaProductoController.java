package com.inventario.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.inventario.demo.model.CategoriaProducto;
import com.inventario.demo.model.Producto;
import com.inventario.demo.service.CategoriaProductoService;

@Controller
@RequestMapping("/v1")
public class CategoriaProductoController {
	
	@Autowired
	CategoriaProductoService _categoriaProductoService;
		
	//GET
	@RequestMapping(value="/categoriasProducto", method = RequestMethod.GET, headers = "Accept=Application/json")
	public ResponseEntity<List<CategoriaProducto>> getCategoriasProductos() {
		
		List<CategoriaProducto> categoriaProductos = new ArrayList<>();
		
		categoriaProductos = _categoriaProductoService.findAllCategoriaProductos();
		if (categoriaProductos.isEmpty() || categoriaProductos == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<CategoriaProducto>>(categoriaProductos, HttpStatus.OK);
	}
	
	//GET BY ID
	@RequestMapping(value="/categoriasProducto/{id}", method = RequestMethod.GET, headers = "Accept=Application/json")
	public ResponseEntity<CategoriaProducto> getCategoriasProductosById(@PathVariable("id") Long idCategoriaProducto) {
		
		if (idCategoriaProducto == null || idCategoriaProducto.equals(null) || idCategoriaProducto <= 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		CategoriaProducto categoriaProducto = _categoriaProductoService.findById(idCategoriaProducto); 
		if (categoriaProducto.equals(null) || categoriaProducto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		ArrayList<List> list = new ArrayList<>();

		List<Producto> productos = categoriaProducto.getProductos();
		if (productos.size() != 0) {
			for (Producto producto : productos) {
				System.out.println("Producto" + producto.getNombre());
				
			}
			categoriaProducto.getProductos().addAll(productos);
		}
		
		return new ResponseEntity<CategoriaProducto>(categoriaProducto, HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(value="/categoriasProducto", method = RequestMethod.POST, headers = "Accept=Application/json")
	public ResponseEntity<?> createCategoriaProducto (@RequestBody CategoriaProducto categoriaProducto, 
			UriComponentsBuilder componentsBuilder) {
	

		if (categoriaProducto.getNombre().equals(null) || categoriaProducto.getNombre() == "" || categoriaProducto.getNombre().isEmpty()) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		
		if (_categoriaProductoService.findByName(categoriaProducto.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		_categoriaProductoService.saveCategoriaProducto(categoriaProducto);
		CategoriaProducto categoriaProducto2 = _categoriaProductoService.findByName(categoriaProducto.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(componentsBuilder.path("/v1/categoriasProducto/{id}")
				.buildAndExpand(categoriaProducto2.getIdCategoriaProducto()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/categoriasProducto/{id}", method = RequestMethod.PATCH, headers = "Accept=Application/json")
	public ResponseEntity<CategoriaProducto> updateCategoriaProducto (@PathVariable("id") Long idCategoriaProducto, @RequestBody CategoriaProducto categoriaProducto) {
		
		if (idCategoriaProducto == null || idCategoriaProducto <= 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		CategoriaProducto currentCategProducto = _categoriaProductoService.findById(idCategoriaProducto);
		if (currentCategProducto == null || currentCategProducto.equals(null)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	    
		currentCategProducto.setNombre(categoriaProducto.getNombre());
		currentCategProducto.setEstado(categoriaProducto.getEstado());

		_categoriaProductoService.updateCategoriaProducto(currentCategProducto);
		return new ResponseEntity<CategoriaProducto>(currentCategProducto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/categoriasProducto/{id}", method = RequestMethod.DELETE, headers = "Accept=Application/json")
	public ResponseEntity<CategoriaProducto> deleteCategoriaProducto (@PathVariable("id") Long idCategoriaProducto) {
		
		if (idCategoriaProducto == null || idCategoriaProducto <= 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		CategoriaProducto categoriaProducto = _categoriaProductoService.findById(idCategoriaProducto);
		if (categoriaProducto == null || categoriaProducto.equals(null)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		_categoriaProductoService.deleteCategoriaProductoById(idCategoriaProducto);
		return new ResponseEntity<CategoriaProducto>(HttpStatus.OK);
	}

}

