package pe.idat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="trabajador")
public class Trabajador implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trabajadorId;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="cargo_id", nullable= false, 
	foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(cargo_id) references cargo(cargo_id) "))
	private Cargo cargo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "trabajador")
	private UserVo uservo;
	
	
	
	public Trabajador() {
	}


	public Trabajador(Integer trabajadorId, String nombre, String apellidos, String email, String telefono) {
		this.trabajadorId = trabajadorId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
	}


	public Integer getTrabajadorId() {
		return trabajadorId;
	}


	public void setTrabajadorId(Integer trabajadorId) {
		this.trabajadorId = trabajadorId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	

}
