package cl.adasoft.departamento.gerencia.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.adasoft.departamento.gerencia.models.entity.Persona;

public interface PersonaDao extends PagingAndSortingRepository<Persona,Long> {
	
	  /* @Query("select p from Persona p where p.id=?1")
	  public Persona findById(Long id); */

	  
	  
}
