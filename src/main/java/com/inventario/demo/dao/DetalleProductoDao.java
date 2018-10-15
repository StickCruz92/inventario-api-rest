package com.inventario.demo.dao;

import java.util.List;

import com.inventario.demo.model.DetalleProducto;

public interface DetalleProductoDao {

	void saveDetalleProducto(DetalleProducto detalleProducto);
	
	void deleteDetalleProductoById(Long idDetalleProducto);
	
	void updateDetalleProducto(DetalleProducto detalleProducto);
	
	List<DetalleProducto> findAllDetalleProductos();
	
	DetalleProducto findById(Long idDetalleProducto);
	
}
