package cl.adasoft.pedidos.gerencia.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.adasoft.pedidos.gerencia.models.dao.PedidoDao;
import cl.adasoft.pedidos.gerencia.models.entity.Pedido;

@Service
public class PedidoServiceImp implements IPedidoService {

	@Autowired
	private PedidoDao participantsDao;

	@Override
	@Transactional(readOnly = true)
	public Page<Pedido> findAll(Pageable pageable) {

		return participantsDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Pedido save(Pedido participant) {

		return participantsDao.save(participant);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		participantsDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido findByRut(Long rut) {

		return participantsDao.findByRut(rut);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findById(Long id) {

		return participantsDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findByCodigo(Long codigo) {

		return participantsDao.findByCodigo(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findByEstado(Long estado) {

		return participantsDao.findByEstado(estado);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findByIdUsuario(Long idUsuario) {

		return participantsDao.findByIdUsuario(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findByIdRepartidor(String idRepartidor) {

		return participantsDao.findByIdRepartidor(idRepartidor);
	}

}
