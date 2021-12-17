package pe.idat.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer horarioId;
	@Column(nullable = false)
	private Time inicio;
	@Column(nullable = false)
	private Time fin;
	
	
	public Horario() {
	}


	public Horario(Integer horarioId, Time inicio, Time fin) {
		this.horarioId = horarioId;
		this.inicio = inicio;
		this.fin = fin;
	}


	public Integer getHorarioId() {
		return horarioId;
	}


	public void setHorarioId(Integer horarioId) {
		this.horarioId = horarioId;
	}


	public Time getInicio() {
		return inicio;
	}


	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}


	public Time getFin() {
		return fin;
	}


	public void setFin(Time fin) {
		this.fin = fin;
	}
	
	
	
	
}
