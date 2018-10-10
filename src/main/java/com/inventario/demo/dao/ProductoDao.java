package com.inventario.demo.dao;

import java.util.List;

import com.inventario.demo.model.Producto;

public interface ProductoDao {

	void saveProducto(Producto Producto);
	
	void deleteProductoById(Long idProducto);
	
	void updateProducto(Producto Producto);
	
	List<Producto> findAllProductos();
	
	Producto findById(Long idProducto);
	
	Producto findByName(String nombre);
	
}
