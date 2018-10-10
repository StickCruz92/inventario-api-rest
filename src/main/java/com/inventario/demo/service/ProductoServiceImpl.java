package com.inventario.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.demo.dao.ProductoDao;
import com.inventario.demo.model.Producto;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao _productoDao;
	
	@Override
	public void saveProducto(Producto Producto) {
		// TODO Auto-generated method stub
		_productoDao.saveProducto(Producto);
	}

	@Override
	public void deleteProductoById(Long idProducto) {
		// TODO Auto-generated method stub
		_productoDao.deleteProductoById(idProducto);
	}

	@Override
	public void updateProducto(Producto Producto) {
		// TODO Auto-generated method stub
		_productoDao.updateProducto(Producto);
	}

	@Override
	public List<Producto> findAllProductos() {
		// TODO Auto-generated method stub
		return _productoDao.findAllProductos();
	}

	@Override
	public Producto findById(Long idProducto) {
		// TODO Auto-generated method stub
		return _productoDao.findById(idProducto);
	}

	@Override
	public Producto findByName(String nombre) {
		// TODO Auto-generated method stub
		return _productoDao.findByName(nombre);
	}

}
