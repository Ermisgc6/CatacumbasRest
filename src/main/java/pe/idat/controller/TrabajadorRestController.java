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

import pe.idat.entity.Trabajador;
import pe.idat.service.TrabajadorService;

@RestController
@RequestMapping("/museo/trabajador")
public class TrabajadorRestController {
	
	@Autowired
	@Qualifier("trabajadorServiceImpl") 
	private TrabajadorService trabajadorservice;

	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(trabajadorservice.findAll(),HttpStatus.OK); 
	}

	@GetMapping("/buscar/{trabajadorId}")
	public ResponseEntity<?> buscar(@PathVariable Integer trabajadorId){
		
		Trabajador trabajador = trabajadorservice.findById(trabajadorId);
		
		if(trabajador!=null) {
			
			return new ResponseEntity<>(trabajador,HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody Trabajador trabajador){
		
		trabajadorservice.insert(trabajador);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{trabajadorId}")
	public ResponseEntity<?> editar(@PathVariable Integer trabajadorId, @RequestBody Trabajador trabajador){
		
		Trabajador trabajadordb = trabajadorservice.findById(trabajadorId);
		
		if(trabajadordb!= null) {
			trabajadordb.setNombre(trabajador.getNombre());
			trabajadordb.setApellidos(trabajador.getApellidos());
			trabajadordb.setEmail(trabajador.getEmail());
			trabajadordb.setTelefono(trabajador.getTelefono());
			trabajadordb.setCargo(trabajador.getCargo());
			trabajadorservice.update(trabajadordb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{trabajadorId}")
	public ResponseEntity<?> borrar(@PathVariable Integer trabajadorId){
		
		Trabajador trabajadordb = trabajadorservice.findById(trabajadorId);
		if(trabajadordb!=null) {
			
			trabajadorservice.delete(trabajadorId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
