package com.inventario.demo.service;

import java.util.List;

import com.inventario.demo.model.CategoriaProducto;

public interface CategoriaProductoService {

	void saveCategoriaProducto(CategoriaProducto categoriaProducto);
	
	void deleteCategoriaProductoById(Long idCategoriaProducto);
	
	void updateCategoriaProducto(CategoriaProducto categoriaProducto);
	
	List<CategoriaProducto> findAllCategoriaProductos();
	
	CategoriaProducto findById(Long idCategoriaProducto);
	
	CategoriaProducto findByName(String name);
	
}
