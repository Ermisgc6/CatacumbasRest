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

import pe.idat.entity.Tarifa;
import pe.idat.service.TarifaService;

@RestController
@RequestMapping("/museo/tarifa")
public class TarifaRestController {

	@Autowired
	@Qualifier("tarifaServiceImpl") 
	private TarifaService tarifaservice;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(tarifaservice.findAll(),HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{tarifaId}")
	public ResponseEntity<?> buscar(@PathVariable Integer tarifaId){
		
		Tarifa tarifa = tarifaservice.findById(tarifaId);
		
		if(tarifa!=null) {
			
			return new ResponseEntity<>(tarifa,HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody Tarifa tarifa){
		
		tarifaservice.insert(tarifa);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{tarifaId}")
	public ResponseEntity<?> editar(@PathVariable Integer tarifaId, @RequestBody Tarifa tarifa){
		
		Tarifa tarifadb = tarifaservice.findById(tarifaId);
		
		if(tarifadb!= null) {
			tarifadb.setDescripcion(tarifa.getDescripcion());
			tarifadb.setPrecio(tarifa.getPrecio());
			tarifaservice.update(tarifadb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{tarifaId}")
	public ResponseEntity<?> borrar(@PathVariable Integer tarifaId){
		
		Tarifa tarifadb = tarifaservice.findById(tarifaId);
		if(tarifadb!=null) {
			
			tarifaservice.delete(tarifaId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
		
}
