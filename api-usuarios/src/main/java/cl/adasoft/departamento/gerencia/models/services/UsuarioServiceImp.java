package cl.adasoft.departamento.gerencia.models.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.adasoft.departamento.gerencia.models.dao.UsuarioDao;
import cl.adasoft.departamento.gerencia.models.entity.Usuario;


@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private UsuarioDao participantsDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> searchAll(Pageable pageable) {

		return participantsDao.searchAll(pageable);
	}

	@Override
	@Transactional
	public Usuario create(Usuario participant) {
		
		return participantsDao.create(participant);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		
		participantsDao.deleteById(id);
	}	

	@Override
	@Transactional
	public void deleteByUsername(String username) {
		
		participantsDao.deleteByUsername(username);
	}	

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		
		return participantsDao.findByUsername(username);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		
		return participantsDao.findById(id);
	}	

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByType(Long type) {
		
		return participantsDao.findByType(type);
	}	
	
}
