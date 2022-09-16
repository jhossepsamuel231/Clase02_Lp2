package com.example.tareaDos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date fechaVenta;
	private List<Detalle> listaDetails;
	
	public Venta() {
		super();
	}
	
	public Venta(int id, Date fechaVenta, List<Detalle> listaDetails) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.listaDetails = listaDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public List<Detalle> getListaDetails() {
		return listaDetails;
	}

	public void setListaDetails(List<Detalle> listaDetails) {
		this.listaDetails = listaDetails;
	}
}