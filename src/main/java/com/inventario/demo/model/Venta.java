package com.inventario.demo.model;

import java.io.Serializable;
import java.util.Date;

public class Venta implements Serializable{

	private Long idVenta;
	private Producto producto;
	private String NombreUsuario;
	private Date fecha;
	private int cantidad;
	private double precio;
	private int estado;
	
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(Long idVenta, String nombreUsuario, Date fecha, int cantidad, double precio, int estado) {
		super();
		this.idVenta = idVenta;
		NombreUsuario = nombreUsuario;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.precio = precio;
		this.estado = estado;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
