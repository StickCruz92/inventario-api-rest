package com.inventario.demo.controller;

import java.util.ArrayList;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.inventario.demo.model.Producto;
import com.inventario.demo.service.ProductoService;
import com.inventario.demo.util.CustomResponseProducto;

@Controller
@RequestMapping("/v1")
public class ProductoController {

	@Autowired
	ProductoService _productoService;
	
	@RequestMapping(value="/productos", method = RequestMethod.GET, headers = "Accept=Application/json")
	public ResponseEntity<?> getProdutos () {
		
		List<Producto> productos = new ArrayList<>();
		
		productos = _productoService.findAllProductos();
		if (productos.isEmpty() || productos == null)  {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(new CustomResponseProducto("OK", "200", productos), HttpStatus.OK);
		//return new ResponseEntity<List<Producto>>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.GET, headers = "Accept=Application/json")
	public ResponseEntity<?> getProductoById(@PathVariable("id") Long idProducto) {

		try {
			if (idProducto == null || idProducto.equals(null) || idProducto <= 0) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			Producto producto = _productoService.findById(idProducto);
			if (producto != null) {
				//return new ResponseEntity<Producto>(producto, HttpStatus.OK);
				return new ResponseEntity(new CustomResponseProducto("OK", "200", producto), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
            //return new ResponseEntity(new CustomErrorType("Unable to create. A course with name " + 
            //		course.getName() + " already exist."),HttpStatus.CONFLICT);

			System.out.println("Fatal Error " + _productoService.findById(idProducto) + " " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@RequestMapping(value="/productos", method = RequestMethod.POST, headers = "Accept=Application/json")
	public ResponseEntity<?> createProducto (@RequestBody Producto producto, UriComponentsBuilder uriComponentsBuilder) {
		
		if (producto.getNombre().equals(null) || producto.getNombre() == null || producto.getNombre().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		if (producto.getCategoriaProducto().getIdCategoriaProducto().equals(null) || producto.getCategoriaProducto().getIdCategoriaProducto() == null || producto.getCategoriaProducto().getIdCategoriaProducto() <= 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		if (_productoService.findByName(producto.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		_productoService.saveProducto(producto);
		Producto currentProducto = _productoService.findByName(producto.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/productos/{id}")
				.buildAndExpand(currentProducto.getIdProducto()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="productos/{id}", method = RequestMethod.PATCH, headers = "Accept=Application/json")
	public ResponseEntity<Producto> updateProducto (@PathVariable("id") Long idProducto, @RequestBody Producto producto) {
		
		if (idProducto == null || idProducto.equals(null) || idProducto <= 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		Producto currentProducto = _productoService.findById(idProducto);
		if (currentProducto.equals(null) || currentProducto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		currentProducto.setNombre(producto.getNombre());
		currentProducto.setEstado(producto.getEstado());
		currentProducto.setCategoriaProducto(producto.getCategoriaProducto());
		
		_productoService.updateProducto(currentProducto);
		return new ResponseEntity<Producto>(currentProducto, HttpStatus.OK);
	}
	
	@RequestMapping(value="productos/{id}", method = RequestMethod.DELETE, headers = "Accept=Application/json")
	public ResponseEntity<?> deleteProducto (@PathVariable("id") Long idProducto) {
		
		if (idProducto == null || idProducto.equals(null) || idProducto <= 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		Producto producto = _productoService.findById(idProducto);
		if (producto != null) {
			_productoService.deleteProductoById(idProducto);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
