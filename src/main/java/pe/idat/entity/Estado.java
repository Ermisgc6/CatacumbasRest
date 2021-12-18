package pe.idat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="estado")
public class Estado implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadoId;
	@Column(nullable = false)
	private String denominacion;
	@Column
	private String descripcion;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private Collection<Entrada> itemsEntrada = new ArrayList<>();
	
	
	public Estado() {
	}

	public Estado(Integer estadoId, String denominacion, String descripcion) {
		this.estadoId = estadoId;
		this.denominacion = denominacion;
		this.descripcion = descripcion;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Entrada> getItemsEntrada() {
		return itemsEntrada;
	}

	public void setItemsEntrada(Collection<Entrada> itemsEntrada) {
		this.itemsEntrada = itemsEntrada;
	}
	
	
	
}
