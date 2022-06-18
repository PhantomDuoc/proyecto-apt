package cl.adasoft.departamento.gerencia.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.adasoft.departamento.gerencia.models.entity.Persona;

public interface PersonaDao extends PagingAndSortingRepository<Persona,Long> {
	
	  @Query("select p from Persona p where p.rut=?1")
	  public Persona findByRut(Long rut);

<<<<<<< HEAD
	  
	  
=======
	@Query("select p from Persona p where p.rut=?1")
	public Persona findByRut(Long rut);
>>>>>>> parent of 15e3d2c (Merge remote-tracking branch 'origin/dev' into felipe)
}
