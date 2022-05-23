package cl.adasoft.departamento.gerencia.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import cl.adasoft.departamento.gerencia.exceptions.NotFoundException;
import cl.adasoft.departamento.gerencia.models.entity.Usuario;
import cl.adasoft.departamento.gerencia.models.services.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserController {
	
	@Autowired 
	private IUsuarioService participantService;
	
	@GetMapping("/searchAll")
	@Operation(summary = "Get users by name", description = "Returns the users filtered by name")
	public Page<Usuario> searchAll(@RequestParam(name="page", defaultValue="0") int page){
		
		Pageable pageRequest =  PageRequest.of(page, 5);
		Page<Usuario> participants = participantService.searchAll(pageRequest);
		return participants;
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Usuario>  create(@RequestBody Usuario usuario) {
		
		return new ResponseEntity<>(participantService.create(usuario),HttpStatus.CREATED);
	}
	
	//Delete por ID
	@DeleteMapping("/deleteById/{id}")
	public void  deleteById(@PathVariable Long id) {
		
		participantService.deleteById(id);
	}
	
	//Delete por nombre de usuario
	@DeleteMapping("/deleteByUsername/{username}")
	public void  deleteByUsername(@PathVariable String username) {
		
		participantService.deleteByUsername(username);
	}
	
	//Encontrar por nombre de usuario
	@GetMapping("/findByUsername/{username}")
	public ResponseEntity<Usuario> findByUsername(@PathVariable String username){
		Usuario response = participantService.findByUsername(username);
		
		if(response == null) {
			throw new NotFoundException("participant username: " + username);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	//Encontrar por ID
	@GetMapping("/findById/{id}")
	public Optional<Usuario>  findById(@PathVariable Long id){
		Optional<Usuario> response = participantService.findById(id);
		
		if(response == null) {
			throw new NotFoundException("participant id: " + id);
		}
		
		return response;
    }

	//Encontrar por Tipo de Usuario
	@GetMapping("/findByType/{type}")
	public Optional<Usuario>  findByType(@PathVariable Long type){
		Optional<Usuario> response = participantService.findByType(type);
		
		if(response == null) {
			throw new NotFoundException("participants type: " + type);
		}
		
		return response;
    }
	
}
