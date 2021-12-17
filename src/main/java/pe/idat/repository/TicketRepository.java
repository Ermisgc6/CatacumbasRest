package pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.idat.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
