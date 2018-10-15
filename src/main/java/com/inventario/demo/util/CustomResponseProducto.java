package com.inventario.demo.util;

import java.util.List;

import com.inventario.demo.model.Producto;

public class CustomResponseProducto {

	private String mensaje;
	private String status;
	private Producto producto;
	private List<Producto> productos;
	
	public CustomResponseProducto(String mensaje, String status, Producto producto) {
		super();
		this.mensaje = mensaje;
		this.status = status;
		this.producto = producto;
	}
	
	public CustomResponseProducto(String mensaje, String status, List<Producto> productos) {
		super();
		this.mensaje = mensaje;
		this.status = status;
		this.productos = productos;
	}
	
	public CustomResponseProducto() {
		// TODO Auto-generated constructor stub
	}

	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
}


