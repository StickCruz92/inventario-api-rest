package com.inventario.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.DetalleProducto;

@Repository
@Transactional
public class DetalleProductoDaoImpl extends AbstractSession implements DetalleProductoDao {

	@Override
	public void saveDetalleProducto(DetalleProducto detalleProducto) {
		// TODO Auto-generated method stub
		getSession().persist(detalleProducto);
	}

	@Override
	public void deleteDetalleProductoById(Long idDetalleProducto) {
		// TODO Auto-generated method stub
		DetalleProducto detalleProducto = findById(idDetalleProducto);
		if (detalleProducto != null) {
			getSession().delete(detalleProducto);
		}
	}

	@Override
	public void updateDetalleProducto(DetalleProducto detalleProducto) {
		// TODO Auto-generated method stub
		getSession().update(detalleProducto);
	}

	@Override
	public List<DetalleProducto> findAllDetalleProductos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from DetalleProducto").list();
	}

	@Override
	public DetalleProducto findById(Long idDetalleProducto) {
		// TODO Auto-generated method stub
		return (DetalleProducto) getSession().get(DetalleProducto.class, idDetalleProducto);
	}

}
