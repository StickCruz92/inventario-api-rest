package com.inventario.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	public Producto(Long idProducto, String nombre, int estado, CategoriaProducto categoriaProducto) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.estado = estado;
		this.categoriaProducto = categoriaProducto;
	}
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private int estado;
	
	/*
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_teacher")
	private Teacher teacher;*/
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria_producto")
	private CategoriaProducto categoriaProducto;

	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
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