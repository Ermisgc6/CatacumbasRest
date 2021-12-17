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
@Table(name="ticket")
public class Ticket implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	@DateTimeFormat(pattern="yyyy-MM-dd", iso=ISO.DATE)
	private LocalDate fechaemision;
	@Column
	private Double subtotal;
	
	//falta entrada y trabajador
	
	public Ticket() {
	}

	public Ticket(Integer ticketId, LocalDate fechaemision, Double subtotal) {
		this.ticketId = ticketId;
		this.fechaemision = fechaemision;
		this.subtotal = subtotal;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDate getFechaemision() {
		return fechaemision;
	}

	public void setFechaemision(LocalDate fechaemision) {
		this.fechaemision = fechaemision;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	
	
	
	
	
	
}
