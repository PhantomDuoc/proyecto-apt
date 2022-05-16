package cl.adasoft.departamento.gerencia.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.adasoft.departamento.gerencia.models.entity.Usuario;

public interface IUsuarioService {
	
	public Page<Usuario> searchAll(Pageable pageable);
	
	public Usuario create(Usuario usuario);
	
	public void deleteById(Long id);
	
	public void deleteByUsername(String username);
	
	public Usuario findById(Long rut);

	public Usuario findByUsername(String username);

	public Usuario findByType(Long type);
	
	public Optional<Usuario> findById(Long rut);

}
