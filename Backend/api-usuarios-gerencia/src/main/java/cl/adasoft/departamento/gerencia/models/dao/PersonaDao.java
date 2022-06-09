package cl.adasoft.departamento.gerencia.models.dao;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.adasoft.departamento.gerencia.models.entity.Persona;

public interface PersonaDao extends PagingAndSortingRepository<Persona, Long> {

	@Query("select p from Persona p where p.rut=?1")
	public Persona findByRut(Long rut);

	@Query("select p from Persona p where p.id=?1")
	public Optional<Persona> findById(Long rut);

	@Query("select p from Persona p where p.nombre like %?1%")
	public Page<Persona> findByName(Pageable pageRequest, String name);

	@Query("select p from Persona p where p.apellido like %?1%")
	public Page<Persona> findByLastName(Pageable pageRequest, String lastName);

	@Query("select p from Persona p where p.nombre like %?1%")
	public Page<Persona> findByNombreContaining(org.springframework.data.domain.Pageable pageRequest, String name);

	@Query("select p from Persona p where p.apellido like %?1%")
	public Page<Persona> findByApellidoContaining(org.springframework.data.domain.Pageable pageRequest,
			String lastName);

	@Query("select p from Persona p where p.rut like %?1%")
	public Page<Persona> findByRut(org.springframework.data.domain.Pageable pageRequest, Long rut);

	@Query("select p from Persona p where p.email like %?1%")
    public Page<Persona> findByEmail(org.springframework.data.domain.Pageable pageRequest, String email);

	@Query("select p from Persona p where p.telefono like %?1%")
    public Page<Persona> findByPhone(org.springframework.data.domain.Pageable pageRequest, String phone);

	@Query("select p from Persona p where p.direccion like %?1%")
    public Page<Persona> findByAddress(org.springframework.data.domain.Pageable pageRequest, String address);

}
