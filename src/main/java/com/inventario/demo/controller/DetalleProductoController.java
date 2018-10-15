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

import com.inventario.demo.model.DetalleProducto;
import com.inventario.demo.service.DetalleProductoService;

@Controller
@RequestMapping("/v1")
public class DetalleProductoController {

	@Autowired
	private DetalleProductoService _detalleProductoService;
	
	@RequestMapping(value="detalleProducto", method = RequestMethod.GET, headers = "Accept=Application/json")
	public ResponseEntity<List<DetalleProducto>> getDetalleProductos () {
		
		List<DetalleProducto> detalleProductos = new ArrayList<>();
		detalleProductos = _detalleProductoService.findAllDetalleProductos();
		
		if (detalleProductos.isEmpty() || detalleProductos == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<DetalleProducto>>(detalleProductos, HttpStatus.OK);
	}

	@RequestMapping(value="detalleProducto/{id}", method = RequestMethod.GET, headers = "Accept=Application/json")
	public ResponseEntity<DetalleProducto> getByIdDetalleProducto (@PathVariable("id") Long idDetalleProducto) {
		
		if (idDetalleProducto.equals(null) || idDetalleProducto <= 0 || idDetalleProducto == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		DetalleProducto detalleProducto = _detalleProductoService.findById(idDetalleProducto);
		if (detalleProducto != null) {
			return new ResponseEntity<DetalleProducto>(detalleProducto, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value="/detalleProducto", method = RequestMethod.POST, headers = "Accept=Application/json")
	public ResponseEntity<DetalleProducto> createDetalleProducto (@RequestBody DetalleProducto detalleProducto, UriComponentsBuilder uriComponentsBuilder) {
				
		_detalleProductoService.saveDetalleProducto(detalleProducto);

		return new ResponseEntity<DetalleProducto>(HttpStatus.CREATED);

	}
	
	@RequestMapping(value="detalleProducto/{id}", method = RequestMethod.PATCH, headers = "Accept=Application/json")
	public ResponseEntity<DetalleProducto> updateDetalleProducto (@PathVariable("id") Long idDetalleProducto ,@RequestBody DetalleProducto detalleProducto) {
		
		if (idDetalleProducto.equals(null) || idDetalleProducto <= 0 || idDetalleProducto == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		DetalleProducto CurrentDetalleProducto = _detalleProductoService.findById(idDetalleProducto);
		if (CurrentDetalleProducto == null || CurrentDetalleProducto.equals(null)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		CurrentDetalleProducto.setCantidad(detalleProducto.getCantidad());
		CurrentDetalleProducto.setDimensiones(detalleProducto.getDimensiones());
		CurrentDetalleProducto.setImagen(detalleProducto.getImagen());
		CurrentDetalleProducto.setPeso(detalleProducto.getPeso());
		CurrentDetalleProducto.setPrecio(detalleProducto.getPrecio());
		CurrentDetalleProducto.setProducto(detalleProducto.getProducto());
		
		_detalleProductoService.updateDetalleProducto(CurrentDetalleProducto);
		return new ResponseEntity<DetalleProducto>(CurrentDetalleProducto, HttpStatus.OK);
	}
	
	@RequestMapping(value="detalleProducto/{id}", method = RequestMethod.DELETE, headers = "Accept=Application/json")
	public ResponseEntity<?> deleteDetalleProducto (@PathVariable("id") Long idDetalleProducto ) {
		
		if (idDetalleProducto.equals(null) || idDetalleProducto <= 0 || idDetalleProducto == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		DetalleProducto detalleProducto = _detalleProductoService.findById(idDetalleProducto);
		if (detalleProducto != null) {
			_detalleProductoService.deleteDetalleProductoById(idDetalleProducto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
	
}
