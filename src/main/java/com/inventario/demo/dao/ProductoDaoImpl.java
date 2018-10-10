package com.inventario.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.Producto;

@Repository
@Transactional
public class ProductoDaoImpl extends AbstractSession implements ProductoDao{

	@Override
	public void saveProducto(Producto Producto) {
		// TODO Auto-generated method stub
		getSession().persist(Producto);
	}

	@Override
	public void deleteProductoById(Long idProducto) {
		// TODO Auto-generated method stub
		Producto producto = findById(idProducto);
		if (producto != null) {
		  getSession().delete(producto);
		}
	}

	@Override
	public void updateProducto(Producto Producto) {
		// TODO Auto-generated method stub
		getSession().update(Producto);
	}

	@Override
	public List<Producto> findAllProductos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Producto").list();
	}

	@Override
	public Producto findById(Long idProducto) {
		// TODO Auto-generated method stub
		return (Producto) getSession().get(Producto.class, idProducto);
	}

	@Override
	public Producto findByName(String nombre) {
		// TODO Auto-generated method stub
		return (Producto) getSession().createQuery("from Producto where nombre = :nombre")
				.setParameter("nombre", nombre).uniqueResult();
	}

}
