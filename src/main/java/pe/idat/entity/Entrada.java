package pe.idat.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	
	
	@ManyToMany
	@JoinTable(name="entrada_tarifa", 
	joinColumns = @JoinColumn(name="entrada_id", nullable=false, 
		foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(entrada_id) references entrada(entrada_id)")), 
		inverseJoinColumns=@JoinColumn(name="tarifa_id", nullable= false,
		foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(tarifa_id) references tarifa(tarifa_id)")))	
	private Set<Tarifa> itemsTarifa = new HashSet<>();
	
	
	
	@ManyToOne
	@JoinColumn(name="horario_id", nullable= false, 
	foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(horario_id) references horario(horario_id) "))
	private Horario horario;
	
	@ManyToOne
	@JoinColumn(name="estado_id", nullable= false, 
	foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(estado_id) references estado(estado_id) "))
	private Estado estado;
	

	
	@JsonIgnore
	@OneToOne(mappedBy = "entrada")
	private Ticket ticket;
	
	
	
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

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
	
}
