package com.coppel.examen.model;

public class Polizas extends Modelo{
	private int idPolizas;
	private int empleadoGenero;
	private String sku;
	private int cantidad;
	private String fecha;

	public Polizas(){
		
	}
	
	public Polizas(int idPolizas, int empleadoGenero, String sku, int cantidad, String fecha) {
		this.idPolizas = idPolizas;
		this.empleadoGenero = empleadoGenero;
		this.sku = sku;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public int getIdPolizas() {
		return idPolizas;
	}
	public void setIdPolizas(int idPolizas) {
		this.idPolizas = idPolizas;
	}
	public int getEmpleadoGenero() {
		return empleadoGenero;
	}
	public void setEmpleadoGenero(int empleadoGenero) {
		this.empleadoGenero = empleadoGenero;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
