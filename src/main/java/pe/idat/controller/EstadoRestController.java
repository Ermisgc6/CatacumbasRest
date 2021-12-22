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

import pe.idat.entity.Estado;
import pe.idat.service.EstadoService;

@RestController
@RequestMapping("/museo/estado")
public class EstadoRestController {

	@Autowired
	@Qualifier("estadoServiceImpl") 
	private EstadoService estadoservice;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(estadoservice.findAll(),HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{estadoId}")
	public ResponseEntity<?> buscar(@PathVariable Integer estadoId){
		
		Estado estado = estadoservice.findById(estadoId);
		
		if(estado!=null) {			
			return new ResponseEntity<>(estado,HttpStatus.OK);
		}	
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody Estado estado){
		
		estadoservice.insert(estado);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{estadoId}")
	public ResponseEntity<?> editar(@PathVariable Integer estadoId, @RequestBody Estado estado){
		
		Estado estadodb = estadoservice.findById(estadoId);
		
		if(estadodb!= null) {
			estadodb.setDenominacion(estado.getDenominacion());
			estadodb.setDescripcion(estado.getDenominacion());
			estadoservice.update(estadodb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/borrar/{estadoId}")
	public ResponseEntity<?> borrar(@PathVariable Integer estadoId){
		
		Estado estadodb = estadoservice.findById(estadoId);
		if(estadodb!=null) {
			
			estadoservice.delete(estadoId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
