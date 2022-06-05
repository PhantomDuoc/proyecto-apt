package cl.adasoft.departamento.gerencia.models.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.adasoft.departamento.gerencia.models.dao.PersonaDao;
import cl.adasoft.departamento.gerencia.models.entity.Persona;


@Service
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	private PersonaDao participantsDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findAll(Pageable pageable) {

		return participantsDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Persona save(Persona participant) {
		
		return participantsDao.save(participant);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		
		participantsDao.deleteById(id);
	}	

	@Override
	@Transactional(readOnly = true)
	public Persona findByRut(Long rut) {
		
		return participantsDao.findByRut(rut);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> findById(Long rut) {
		
		return participantsDao.findById(rut);
	}	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findByName(Pageable pageRequest, String name) {
		
		return participantsDao.findByNombreContaining(pageRequest, name);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findByLastName(Pageable pageRequest, String lastName) {
		
		return participantsDao.findByApellidoContaining(pageRequest, lastName);
	}

	@Override
	public Page<Persona> findByRut(Pageable pageRequest, Long rut) {
		// TODO Auto-generated method stub

		return participantsDao.findByRut(pageRequest, rut);
	}

	@Override
	public Page<Persona> findByEmail(Pageable pageRequest, String email) {
		// TODO Auto-generated method stub
		return participantsDao.findByEmail(pageRequest, email);
	}

	@Override
	public Page<Persona> findByPhone(Pageable pageRequest, String phone) {
		// TODO Auto-generated method stub
		return participantsDao.findByPhone(pageRequest, phone);
	}

	@Override
	public Page<Persona> findByAddress(Pageable pageRequest, String address) {
		// TODO Auto-generated method stub
		return participantsDao.findByAddress(pageRequest, address);
	}
}
