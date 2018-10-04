package com.inventario.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.inventario.demo.model.CategoriaProducto;
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
	
	//POST
	@RequestMapping(value="/categoriasProducto", method = RequestMethod.POST, headers = "Accept = Application/json")
	public ResponseEntity<?> createCategoriaProducto (@RequestBody CategoriaProducto categoriaProducto, 
			UriComponentsBuilder componentsBuilder) {
		
		if (categoriaProducto.getNombre().equals(null)) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		
		if (_categoriaProductoService.findByName(categoriaProducto.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		
		_categoriaProductoService.saveCategoriaProducto(categoriaProducto);
		CategoriaProducto categoriaProducto2 = _categoriaProductoService.findByName(categoriaProducto.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(componentsBuilder.path("/v1/categoriasProducto/{id}")
				.buildAndExpand(categoriaProducto2.getIdCategoriaProducto()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}

