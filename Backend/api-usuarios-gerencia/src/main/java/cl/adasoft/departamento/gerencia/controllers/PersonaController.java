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

@CrossOrigin(origins = "http://localhost:8100")   //para permitir el acceso a la api desde cualquier origen
@RestController  //para que sea un controlador rest
public class PersonaController {
	
	@Autowired 
	private IPersonaService participantService;  //para inyectar el servicio
	
	@GetMapping("/findAll")  //para indicarle a spring que es una peticion get
	@Operation(summary = "Get users by name", description = "Returns the users filtered by name")  //para indicarle a swagger que es una operacion get
	public Page<Persona> findAll(@RequestParam(name="page", defaultValue="0") int page){  //para indicarle a spring que es una peticion get
		
		Pageable pageRequest =  PageRequest.of(page, 5);  
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

	@GetMapping(/*"/findByName/{name}"*/)
	public Page<Persona> findByName(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name="name", defaultValue="") String name){
		Pageable pageRequest =  PageRequest.of(page, 5);  
		Page<Persona> participants = participantService.findByName(pageRequest, name);
		return participants;
	}

	@PutMapping("/update")
	public ResponseEntity<Persona> update(@RequestBody Persona persona){
		return new ResponseEntity<>(participantService.save(persona),HttpStatus.CREATED);
	}

	@Operation
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id){  
		participantService.delete(id);
	}
	
}
