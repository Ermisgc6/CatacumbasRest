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
@Table(name="cargo")
public class Cargo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cargoId;
	@Column
	private String denominacion;
	@Column
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cargo")
	private Collection<Trabajador> itemsTrabajador = new ArrayList<>();
	
	
	public Cargo() {
	}

	public Cargo(Integer cargoId, String denominacion, String descripcion) {
		this.cargoId = cargoId;
		this.denominacion = denominacion;
		this.descripcion = descripcion;
	}



	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
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

	public Collection<Trabajador> getItemsTrabajador() {
		return itemsTrabajador;
	}

	public void setItemsTrabajador(Collection<Trabajador> itemsTrabajador) {
		this.itemsTrabajador = itemsTrabajador;
	}
	
	
	

}
