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

import pe.idat.entity.Horario;
import pe.idat.service.HorarioService;

@RestController
@RequestMapping("/museo/horario")
public class HorarioRestController {

	@Autowired
	@Qualifier("horarioServiceImpl") 
	private HorarioService horarioservice;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(horarioservice.findAll(),HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{horarioId}")
	public ResponseEntity<?> buscar(@PathVariable Integer horarioId){
		
		Horario horario = horarioservice.findById(horarioId);
		
		if(horario!=null) {
			
			return new ResponseEntity<>(horario,HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody Horario horario){
		
		horarioservice.insert(horario);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{horarioId}")
	public ResponseEntity<?> editar(@PathVariable Integer horarioId, @RequestBody Horario horario){
		
		Horario horariodb = horarioservice.findById(horarioId);
		
		if(horariodb!= null) {
			horariodb.setInicio(horario.getInicio());
			horariodb.setFin(horario.getFin());
			horarioservice.update(horariodb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{horarioId}")
	public ResponseEntity<?> borrar(@PathVariable Integer horarioId){
		
		Horario horariodb = horarioservice.findById(horarioId);
		if(horariodb!=null) {
			
			horarioservice.delete(horarioId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
