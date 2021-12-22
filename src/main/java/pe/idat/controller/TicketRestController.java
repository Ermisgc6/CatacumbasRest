package pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.entity.Ticket;
import pe.idat.service.TicketService;

@RestController
@RequestMapping("/museo/ticket")
public class TicketRestController {

	@Autowired
	@Qualifier("ticketServiceImpl") 
	private TicketService ticketservice;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(ticketservice.findAll(),HttpStatus.OK); 
	}

	@GetMapping("/buscar/{ticketId}")
	public ResponseEntity<?> buscar(@PathVariable Integer ticketId){
		
		Ticket ticket = ticketservice.findById(ticketId);
		
		if(ticket!=null) {
			
			return new ResponseEntity<>(ticket,HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody Ticket ticket){
		
		ticketservice.insert(ticket);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{ticketId}")
	public ResponseEntity<?> editar(@PathVariable Integer ticketId, @RequestBody Ticket ticket){
		
		Ticket ticketdb = ticketservice.findById(ticketId);
		
		if(ticketdb!= null) {
			ticketdb.setFechaemision(ticket.getFechaemision());
			ticketdb.setSubtotal(ticket.getSubtotal());
			ticketdb.setEntrada(ticket.getEntrada());
			ticketdb.setTrabajador(ticket.getTrabajador());
			ticketservice.update(ticketdb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{ticketId}")
	public ResponseEntity<?> borrar(@PathVariable Integer ticketId){
		
		Ticket ticketdb = ticketservice.findById(ticketId);
		if(ticketdb!=null) {
			
			ticketservice.delete(ticketId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
