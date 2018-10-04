package com.inventario.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.demo.dao.CategoriaProductoDao;
import com.inventario.demo.model.CategoriaProducto;

@Service("categoriaProductoService")
@Transactional
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

	@Autowired
	private CategoriaProductoDao _categoriaProductoDao;
	
	@Override
	public void saveCategoriaProducto(CategoriaProducto categoriaProducto) {
		// TODO Auto-generated method stub
		_categoriaProductoDao.saveCategoriaProducto(categoriaProducto);
	}

	@Override
	public void deleteCategoriaProductoById(Long idCategoriaProducto) {
		// TODO Auto-generated method stub
		_categoriaProductoDao.deleteCategoriaProductoById(idCategoriaProducto);
	}

	@Override
	public void updateCategoriaProducto(CategoriaProducto categoriaProducto) {
		// TODO Auto-generated method stub
		_categoriaProductoDao.updateCategoriaProducto(categoriaProducto);
	}

	@Override
	public List<CategoriaProducto> findAllCategoriaProductos() {
		// TODO Auto-generated method stub
		return _categoriaProductoDao.findAllCategoriaProductos();
	}

	@Override
	public CategoriaProducto findById(Long idCategoriaProducto) {
		// TODO Auto-generated method stub
		return _categoriaProductoDao.findById(idCategoriaProducto);
	}

	@Override
	public CategoriaProducto findByName(String name) {
		// TODO Auto-generated method stub
		return _categoriaProductoDao.findByName(name);
	}

}
