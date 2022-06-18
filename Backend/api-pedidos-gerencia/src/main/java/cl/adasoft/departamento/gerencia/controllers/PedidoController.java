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
import cl.adasoft.departamento.gerencia.models.entity.Pedido;
import cl.adasoft.departamento.gerencia.models.services.IPedidoService;

import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PedidoController {
	
	@Autowired 
	private IPedidoService participantService;

	@GetMapping("/findAll")
	@Operation(summary = "Get users by name", description = "Returns the users filtered by name")
	public Page<Pedido> findAll(@RequestParam(name="page", defaultValue="0") int page){
		
		Pageable pageRequest =  PageRequest.of(page, 5);  
		Page<Pedido> participants = participantService.findAll(pageRequest);  //para obtener todos los participantes
		return participants;  //para retornar los participantes
		
	}
	
	@PostMapping("/create")  //para indicarle a spring que es una peticion post
	public ResponseEntity<Pedido>  save(@RequestBody Pedido pedido) {  
		
		return new ResponseEntity<>(participantService.save(pedido),HttpStatus.CREATED);  //para retornar el objeto Pedido y el codigo de estado
	}
	
	
	@DeleteMapping("/delete/{id}")  //para indicarle a spring que es una peticion delete
	public void  update(@PathVariable Long id) {  
		
		participantService.delete(id);  //para eliminar el objeto Pedido
	}	
	
	@GetMapping("/findByRut/{rut}")	 	
	public ResponseEntity<Pedido> findByRut(@PathVariable Long rut){
		Pedido response = participantService.findByRut(rut);
		
		if(response == null) {
			throw new NotFoundException("participant rut: " + rut);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
	@GetMapping("/findById/{id}")
	public Optional<Pedido>  findById(@PathVariable Long id){
		Optional<Pedido> response = participantService.findById(id);
		
		if(response == null) {
			throw new NotFoundException("participant id: " + id);
		}
		
		return response;
    }

	@PutMapping("/update")
	public ResponseEntity<Pedido> update(@RequestBody Pedido pedido){
		return new ResponseEntity<>(participantService.save(pedido),HttpStatus.CREATED);
	}

	@GetMapping("/findByCodigo/{codigo}")
	public Optional<Pedido> findByCodigo(@PathVariable Long codigo){
		Optional<Pedido> response = participantService.findByCodigo(codigo);
		
		if(response == null) {
			throw new NotFoundException("participant codigo: " + codigo);
		}
		
		return response;
	}

	@GetMapping("/findByEstado/{estado}")
	public Optional<Pedido> findByEstado(@PathVariable Long estado){
		Optional<Pedido> response = participantService.findByEstado(estado);
		
		if(response == null) {
			throw new NotFoundException("participant estado: " + estado);
		}
		
		return response;
	}

	@GetMapping("/findByIdUsuario/{idUsuario}")
	public Optional<Pedido> findByIdUsuario(@PathVariable Long idUsuario){
		Optional<Pedido> response = participantService.findByIdUsuario(idUsuario);
		
		if(response == null) {
			throw new NotFoundException("participant idUsuario: " + idUsuario);
		}
		
		return response;
	}

	@GetMapping("/findByIdRepartidor/{idRepartidor}")
	public Optional<Pedido> findByIdRepartidor(@PathVariable Long idRepartidor){
		Optional<Pedido> response = participantService.findByIdRepartidor(idRepartidor);
		
		if(response == null) {
			throw new NotFoundException("participant idRepartidor: " + idRepartidor);
		}
		
		return response;
	}
	
}