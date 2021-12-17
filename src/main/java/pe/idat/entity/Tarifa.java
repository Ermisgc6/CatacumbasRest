package pe.idat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarifa")
public class Tarifa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tarifaId;
	@Column
	private String descripcion;
	@Column(nullable = false)
	private Double precio;
	
	
	public Tarifa() {
	}


	public Tarifa(Integer tarifaId, String descripcion, Double precio) {
		this.tarifaId = tarifaId;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public Integer getTarifaId() {
		return tarifaId;
	}


	public void setTarifaId(Integer tarifaId) {
		this.tarifaId = tarifaId;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
	
}
