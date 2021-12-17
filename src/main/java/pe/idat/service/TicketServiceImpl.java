package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Ticket;
import pe.idat.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public void insert(Ticket ticket) {
		repository.save(ticket);
	}

	@Override
	@Transactional(readOnly = true)
	public void update(Ticket ticket) {
		repository.save(ticket);
		
	}

	@Override
	@Transactional
	public void delete(Integer ticketId) {
		repository.deleteById(ticketId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Ticket findById(Integer ticketId) {
		return repository.findById(ticketId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Ticket> findAll() {
		return repository.findAll();
	}

}
