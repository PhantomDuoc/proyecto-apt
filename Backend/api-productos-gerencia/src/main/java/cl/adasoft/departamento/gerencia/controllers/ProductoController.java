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

import cl.adasoft.departamento.gerencia.exceptions.NotFoundException;
import cl.adasoft.departamento.gerencia.models.entity.Producto;
import cl.adasoft.departamento.gerencia.models.services.IProductoService;

import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService participantService;

	@GetMapping("/findAll")
	@Operation(summary = "Get users by name", description = "Returns the users filtered by name")
	public Page<Producto> findAll(@RequestParam(name = "page", defaultValue = "0") int page) {

		Pageable pageRequest = PageRequest.of(page, 6);
		Page<Producto> participants = participantService.findAll(pageRequest);
		return participants;

	}

	@PostMapping("/create")
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {

		return new ResponseEntity<>(participantService.save(producto), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public void update(@PathVariable Long id) {

		participantService.delete(id);
	}

	@GetMapping("/findById/{id}")
	public Optional<Producto> findById(@PathVariable Long id) {
		Optional<Producto> response = participantService.findById(id);

		if (response == null) {
			throw new NotFoundException("participant id: " + id);
		}

		return response;
	}

	@GetMapping("/findByNombre/{nombre}")
	public Page<Producto> findByNombre(@PathVariable String nombre,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Producto> participants = participantService.findByNombre(nombre, pageRequest);
		return participants;

	}

	@GetMapping("/findByDescripcion/{descripcion}")
	public Page<Producto> findByDescripcion(@PathVariable String descripcion,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Producto> participants = participantService.findByDescripcion(descripcion, pageRequest);
		return participants;

	}

	@GetMapping("/findByPrecio/{precio}")
	public Page<Producto> findByPrecio(@PathVariable Double precio,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Producto> participants = participantService.findByPrecio(precio, pageRequest);
		return participants;

	}

	@GetMapping("/findByStock/{stock}")
	public Page<Producto> findByStock(@PathVariable Integer stock,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Producto> participants = participantService.findByStock(stock, pageRequest);
		return participants;

	}

	@GetMapping("/findByCategoria/{categoria}")
	public Page<Producto> findByCategoria(@PathVariable String categoria,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Producto> participants = participantService.findByCategoria(categoria, pageRequest);
		return participants;

	}

	@GetMapping("/findByCodigo/{codigo}")
	public Page<Producto> findByCodigo(@PathVariable String codigo,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Producto> participants = participantService.findByCodigo(codigo, pageRequest);
		return participants;

	}
}
