package com.inventario.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.CategoriaProducto;

@Repository
@Transactional
public class CatalogoProductoDaoImpl extends AbstractSession implements CategoriaProductoDao {

	@Override
	public void saveCategoriaProducto(CategoriaProducto categoriaProducto) {
		// TODO Auto-generated method stub
		getSession().persist(categoriaProducto);
	}

	@Override
	public void deleteCategoriaProductoById(Long idCategoriaProducto) {
		// TODO Auto-generated method stub
		CategoriaProducto categoriaProducto = findById(idCategoriaProducto);
		if (categoriaProducto != null) {
			getSession().delete(categoriaProducto);
		}
	}

	@Override
	public void updateCategoriaProducto(CategoriaProducto categoriaProducto) {
		// TODO Auto-generated method stub
		getSession().update(categoriaProducto);
	}

	@Override
	public List<CategoriaProducto> findAllCategoriaProductos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from CategoriaProducto where estado = 1").list();
	}

	@Override
	public CategoriaProducto findById(Long idCategoriaProducto) {
		// TODO Auto-generated method stub
		return (CategoriaProducto) getSession().get(CategoriaProducto.class, idCategoriaProducto);
	}

	@Override
	public CategoriaProducto findByName(String nombre) {
		// TODO Auto-generated method stub
		return (CategoriaProducto) getSession().createQuery("from CategoriaProducto where nombre = :nombre")
				.setParameter("nombre", nombre).uniqueResult();
	}

}
