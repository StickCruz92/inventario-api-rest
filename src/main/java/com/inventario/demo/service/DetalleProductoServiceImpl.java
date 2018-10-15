package com.inventario.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.demo.dao.DetalleProductoDao;
import com.inventario.demo.model.DetalleProducto;

@Service("detalleProductoService")
@Transactional
public class DetalleProductoServiceImpl implements DetalleProductoService{

	@Autowired
	private DetalleProductoDao _detalleProductoDao;
	
	@Override
	public void saveDetalleProducto(DetalleProducto detalleProducto) {
		// TODO Auto-generated method stub
		_detalleProductoDao.saveDetalleProducto(detalleProducto);
	}

	@Override
	public void deleteDetalleProductoById(Long idDetalleProducto) {
		// TODO Auto-generated method stub
		_detalleProductoDao.deleteDetalleProductoById(idDetalleProducto);
	}

	@Override
	public void updateDetalleProducto(DetalleProducto detalleProducto) {
		// TODO Auto-generated method stub
		_detalleProductoDao.updateDetalleProducto(detalleProducto);
	}

	@Override
	public List<DetalleProducto> findAllDetalleProductos() {
		// TODO Auto-generated method stub
		return _detalleProductoDao.findAllDetalleProductos();
	}

	@Override
	public DetalleProducto findById(Long idDetalleProducto) {
		// TODO Auto-generated method stub
		return _detalleProductoDao.findById(idDetalleProducto);
	}

}
