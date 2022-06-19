package cl.adasoft.departamento.gerencia.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.adasoft.departamento.gerencia.exceptions.NotFoundException;
import cl.adasoft.departamento.gerencia.models.entity.Persona;
import cl.adasoft.departamento.gerencia.models.services.IPersonaService;

import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PersonaController {
	
	@Autowired 
	private IPersonaService participantService;

	@GetMapping("/findAll")
	@Operation(summary = "Get users by name", description = "Returns the users filtered by name")
	public Page<Persona> findAll(@RequestParam(name="page", defaultValue="0") int page){
		
		Pageable pageRequest =  PageRequest.of(page, 5, org.springframework.data.domain.Sort.by("id"));  
		Page<Persona> participants = participantService.findAll(pageRequest);  //para obtener todos los participantes
		return participants;  //para retornar los participantes
		
	}
	
	@PostMapping("/create")  //para indicarle a spring que es una peticion post
	public ResponseEntity<Persona>  save(@RequestBody Persona persona) {  
		
		return new ResponseEntity<>(participantService.save(persona),HttpStatus.CREATED);  //para retornar el objeto persona y el codigo de estado
	}
	
	
	@DeleteMapping("/delete/{id}")  //para indicarle a spring que es una peticion delete
	public void  update(@PathVariable Long id) {  
		
		participantService.delete(id);  //para eliminar el objeto persona
	}	
	
	@GetMapping("/findByRut/{rut}")	 	
	public ResponseEntity<Persona> findByRut(@PathVariable Long rut){
		Persona response = participantService.findByRut(rut);
		
		if(response == null) {
			throw new NotFoundException("participant rut: " + rut);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
	@GetMapping("/findById/{id}")
	public Optional<Persona>  findById(@PathVariable Long id){
		Optional<Persona> response = participantService.findById(id);
		
		if(response == null) {
			throw new NotFoundException("participant id: " + id);
		}
		
		return response;
    }

	@PutMapping("/update")
	public ResponseEntity<Persona> update(@RequestBody Persona persona){
		return new ResponseEntity<>(participantService.save(persona),HttpStatus.CREATED);
	}
	
	@GetMapping("/findByUsername/{username}")
	public Optional<Persona>  findByUsername(@PathVariable String username){
		Optional<Persona> response = participantService.findByUsername(username);
		
		if(response == null) {
			throw new NotFoundException("participant username: " + username);
		}
		
		return response;
    }

	@GetMapping("/findByType/{type}")
	public Page<Persona> findByType(@PathVariable Long type, @RequestParam(name="page", defaultValue="0") int page){
		
		Pageable pageRequest =  PageRequest.of(page, 5, org.springframework.data.domain.Sort.by("id"));  
		Page<Persona> participants = participantService.findByType(type, pageRequest);  //para obtener todos los participantes
		return participants;  //para retornar los participantes
		
	}
}
