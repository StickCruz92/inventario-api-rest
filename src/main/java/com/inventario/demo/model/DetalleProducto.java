package com.inventario.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_producto")
public class DetalleProducto implements Serializable{
	
	@Id
	@Column(name="id_detalle_producto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetalleProducto;
	
	@Column(name="peso")
	private double peso;
	
	@Column(name="dimensiones")
	private String dimensiones;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="imagen")
	private String imagen;
	
	@Column(name="precio")
	private double precio;
	
	
	public DetalleProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getIdDetalleProducto() {
		return idDetalleProducto;
	}
	public void setIdDetalleProducto(Long idDetalleProducto) {
		this.idDetalleProducto = idDetalleProducto;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

}
