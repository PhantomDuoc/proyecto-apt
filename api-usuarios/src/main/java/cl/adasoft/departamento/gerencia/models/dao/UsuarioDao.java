package cl.adasoft.departamento.gerencia.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.adasoft.departamento.gerencia.models.entity.Usuario;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario,Long> {
	
	  @Query("select u from User u where u.username=?1")
	  public Usuario findByUsername(String username);

	  
	  
}
