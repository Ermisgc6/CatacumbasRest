package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.Ticket;

public interface TicketService {

	public abstract void insert(Ticket ticket);
	public abstract void update(Ticket ticket);
	public abstract void delete(Integer ticketId);
	public abstract Ticket findById(Integer ticketId);
	public abstract Collection<Ticket> findAll();
}
