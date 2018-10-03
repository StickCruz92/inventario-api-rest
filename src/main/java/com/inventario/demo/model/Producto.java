package com.inventario.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="producto")
public class Producto implements Serializable{

	@Id
	@Column(name="id_producto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProducto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria_producto")
	@JsonIgnore
	private CategoriaProducto categoriaProducto;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_detalle_producto")
	@JsonIgnore
	private DetalleProducto detalleProducto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private int estado;
	
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Long idProducto, CategoriaProducto categoriaProducto, DetalleProducto detalleProducto,
			String nombre, int estado) {
		super();
		this.idProducto = idProducto;
		this.categoriaProducto = categoriaProducto;
		this.detalleProducto = detalleProducto;
		this.nombre = nombre;
		this.estado = estado;
	}



	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}
	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	public DetalleProducto getDetalleProducto() {
		return detalleProducto;
	}
	public void setDetalleProducto(DetalleProducto detalleProducto) {
		this.detalleProducto = detalleProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
