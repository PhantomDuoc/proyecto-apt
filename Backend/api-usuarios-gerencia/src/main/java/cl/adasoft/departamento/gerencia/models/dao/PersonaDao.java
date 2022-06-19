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

	@Query("select p from Persona p where p.username=?1")
    public Optional<Persona> findByUsername(String username);

	@Query("select p from Persona p where p.type=?1")
	public Page<Persona> findByType(Long type, org.springframework.data.domain.Pageable pageRequest);
}
