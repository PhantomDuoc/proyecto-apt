package cl.adasoft.departamento.gerencia.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.adasoft.departamento.gerencia.models.dao.ProductoDao;
import cl.adasoft.departamento.gerencia.models.dao.ProductoDao;
import cl.adasoft.departamento.gerencia.models.entity.Producto;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ProductoDao participantsDao;

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {

		return participantsDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Producto save(Producto participant) {

		return participantsDao.save(participant);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		participantsDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long id) {

		return participantsDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findByNombre(String nombre, Pageable pageable) {

		return participantsDao.findByNombre(nombre, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findByCodigo(Long codigo, Pageable pageable) {

		return participantsDao.findByCodigo(codigo, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findByPrecio(Long precio, Pageable pageable) {

		return participantsDao.findByPrecio(precio, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findByStock(Long stock, Pageable pageable) {

		return participantsDao.findByStock(stock, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findByCategoria(String categoria, Pageable pageable) {

		return participantsDao.findByCategoria(categoria, pageable);
	}

	@Override
	public Page<Producto> findByDescripcion(String descripcion, Pageable pageable) {
		return participantsDao.findByDescripcion(descripcion, pageable);
	}

}
