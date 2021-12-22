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

import pe.idat.entity.Entrada;
import pe.idat.service.EntradaService;

@RestController
@RequestMapping("/museo/entrada")
public class EntradaRestController {

	@Autowired
	@Qualifier("entradaServiceImpl") 
	private EntradaService entradaservice;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(entradaservice.findAll(),HttpStatus.OK); 
	}

	@GetMapping("/buscar/{entradaId}")
	public ResponseEntity<?> buscar(@PathVariable Integer entradaId){
		
		Entrada entrada = entradaservice.findById(entradaId);
		
		if(entrada!=null) {
			
			return new ResponseEntity<>(entrada,HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody Entrada entrada){
		
		entradaservice.insert(entrada);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{entradaId}")
	public ResponseEntity<?> editar(@PathVariable Integer entradaId, @RequestBody Entrada entrada){
		
		Entrada entradadb = entradaservice.findById(entradaId);
		
		if(entradadb!= null) {
			entradadb.setNombrecli(entrada.getNombrecli());
			entradadb.setApellidoscli(entrada.getApellidoscli());
			entradadb.setEmailcli(entrada.getEmailcli());
			entradadb.setTipodoc(entrada.getTipodoc());
			entradadb.setNumdoc(entrada.getNumdoc());
			entradadb.setFechaprogramada(entrada.getFechaprogramada());
			entradadb.setEstado(entrada.getEstado());
			entradadb.setHorario(entrada.getHorario());
			entradaservice.update(entradadb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{entradaId}")
	public ResponseEntity<?> borrar(@PathVariable Integer entradaId){
		
		Entrada entradadb = entradaservice.findById(entradaId);
		if(entradadb!=null) {
			
			entradaservice.delete(entradaId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
