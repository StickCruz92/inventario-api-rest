package com.inventario.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categoria_producto")
public class CategoriaProducto implements Serializable {
	
	@Id
	@Column(name="id_categoria_prodcuto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoriaProdcuto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private int estado;
	
	@OneToMany(mappedBy="categoriaProducto", cascade =CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Producto> productos = new ArrayList<>();
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public CategoriaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaProducto(Long idCategoriaProdcuto, String nombre, int estado) {
		super();
		this.idCategoriaProdcuto = idCategoriaProdcuto;
		this.nombre = nombre;
		this.estado = estado;
	}
	public Long getIdCategoriaProdcuto() {
		return idCategoriaProdcuto;
	}
	public void setIdCategoriaProdcuto(Long idCategoriaProdcuto) {
		this.idCategoriaProdcuto = idCategoriaProdcuto;
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
