package pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.entity.Cargo;
import pe.idat.service.CargoService;

@RestController
@RequestMapping("/museo/cargo")
public class CargoRestController {

	@Autowired
	@Qualifier("cargoServiceImpl") 
	private CargoService cargoservice;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
			return new ResponseEntity<>(cargoservice.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{cargoId}")
	public ResponseEntity<?> buscar(@PathVariable Integer cargoId){
		
		Cargo cargo = cargoservice.findById(cargoId);
		
		if(cargo!=null) {
			return new ResponseEntity<>(cargo,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody Cargo cargo){
		
		cargoservice.insert(cargo);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{cargoId}")
	public ResponseEntity<?> editar(@PathVariable Integer cargoId, @RequestBody Cargo cargo){
		
		Cargo cargodb = cargoservice.findById(cargoId);
		
		if(cargodb!= null) {
			cargodb.setDenominacion(cargo.getDenominacion());
			cargodb.setDescripcion(cargo.getDescripcion());
			
			cargoservice.update(cargodb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{cargoId}")
	public ResponseEntity<?> borrar(@PathVariable Integer cargoId){
		
		Cargo cargodb = cargoservice.findById(cargoId);
		if(cargodb!=null) {
			
			cargoservice.delete(cargoId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
