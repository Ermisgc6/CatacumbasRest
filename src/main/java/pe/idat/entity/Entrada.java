package pe.idat.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="entrada")
public class Entrada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entradaId;
	@Column(nullable = false)
	private String nombrecli;
	@Column(nullable = false)
	private String apellidoscli;
	@Column(nullable = false, unique = true)
	private String emailcli;
	@Column(nullable = false)
	private String tipodoc;
	@Column(nullable = false, unique = true)
	private String numdoc;
	@DateTimeFormat(pattern="yyyy-MM-dd", iso=ISO.DATE)
	private LocalDate fechaprogramada;
	
	//falta horario y estado
	
	
	public Entrada() {
	}

	public Entrada(String nombrecli, String apellidoscli, String emailcli, String tipodoc, String numdoc,
			LocalDate fechaprogramada) {
		this.nombrecli = nombrecli;
		this.apellidoscli = apellidoscli;
		this.emailcli = emailcli;
		this.tipodoc = tipodoc;
		this.numdoc = numdoc;
		this.fechaprogramada = fechaprogramada;
	}

	public Integer getEntradaId() {
		return entradaId;
	}

	public void setEntradaId(Integer entradaId) {
		this.entradaId = entradaId;
	}

	public String getNombrecli() {
		return nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}

	public String getApellidoscli() {
		return apellidoscli;
	}

	public void setApellidoscli(String apellidoscli) {
		this.apellidoscli = apellidoscli;
	}

	public String getEmailcli() {
		return emailcli;
	}

	public void setEmailcli(String emailcli) {
		this.emailcli = emailcli;
	}

	public String getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	public String getNumdoc() {
		return numdoc;
	}

	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}

	public LocalDate getFechaprogramada() {
		return fechaprogramada;
	}

	public void setFechaprogramada(LocalDate fechaprogramada) {
		this.fechaprogramada = fechaprogramada;
	}
	
	
	
	
}
