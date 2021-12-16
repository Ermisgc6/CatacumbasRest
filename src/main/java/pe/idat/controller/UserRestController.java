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


import pe.idat.entity.UserVo;
import pe.idat.service.UserService;

@RestController
@RequestMapping("/museo/usuario")
public class UserRestController {
	
	
	@Autowired
	@Qualifier("userServiceImpl") 
	private UserService userservice;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(userservice.findAll(),HttpStatus.OK); 
	}

	@GetMapping("/buscar/{usuarioId}")
	public ResponseEntity<?> buscar(@PathVariable Integer usuarioId){
		
		UserVo usuario = userservice.findById(usuarioId);
		
		if(usuario!=null) {
			
			return new ResponseEntity<>(usuario,HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody UserVo usuario){
		
		userservice.insert(usuario);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar/{usuarioId}")
	public ResponseEntity<?> editar(@PathVariable Integer usuarioId, @RequestBody UserVo usuario){
		
		UserVo usuariodb = userservice.findById(usuarioId);
		
		if(usuariodb!= null) {
			usuariodb.setUsuario(usuario.getUsuario());
			usuariodb.setContraseña(usuario.getContraseña());
			usuariodb.setTrabajador(usuario.getTrabajador());
			userservice.update(usuariodb);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{usuarioId}")
	public ResponseEntity<?> borrar(@PathVariable Integer usuarioId){
		
		UserVo usuariodb = userservice.findById(usuarioId);
		if(usuariodb!=null) {
			
			userservice.delete(usuarioId);
			return new  ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
