package cl.adasoft.departamento.gerencia.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.adasoft.departamento.gerencia.models.entity.Persona;

public interface IPersonaService {
	
	public Page<Persona> findAll(Pageable pageable);
	
	public Persona save(Persona persona);
	
	public void delete(Long id);	
	
	public Persona findByRut(Long rut);
	
	public Optional<Persona> findById(Long rut);

    public Page<Persona> findByName(Pageable pageRequest, String name);

	public Page<Persona> findByLastName(Pageable pageRequest, String lastName);

	public Page<Persona> findByRut(Pageable pageRequest, Long rut);

	public Page<Persona> findByEmail(Pageable pageRequest, String email);

	public Page<Persona> findByPhone(Pageable pageRequest, String phone);

	public Page<Persona> findByAddress(Pageable pageRequest, String address);

	

}
