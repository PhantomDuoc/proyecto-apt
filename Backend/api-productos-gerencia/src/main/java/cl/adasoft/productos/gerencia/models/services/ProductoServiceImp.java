package cl.adasoft.productos.gerencia.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD:Backend/api-productos-gerencia/src/main/java/cl/adasoft/departamento/gerencia/models/services/ProductoServiceImp.java
import cl.adasoft.departamento.gerencia.models.dao.ProductoDao;
import cl.adasoft.departamento.gerencia.models.dao.ProductoDao;
import cl.adasoft.departamento.gerencia.models.entity.Producto;
=======
import cl.adasoft.productos.gerencia.models.dao.ProductoDao;
import cl.adasoft.productos.gerencia.models.entity.Producto;
>>>>>>> hai:Backend/api-productos-gerencia/src/main/java/cl/adasoft/productos/gerencia/models/services/ProductoServiceImp.java

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ProductoDao participantsDao;

	@Override
	@Transactional
	public void delete(Long id) {

		participantsDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {

		return participantsDao.findAll(pageable);
	}

	@Override
	public Page<Producto> findByCategoria(String categoria, Pageable pageRequest) {
		// TODO Auto-generated method stub
		return participantsDao.findByCategoria(categoria, pageRequest);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findByCodigo(String codigo, Pageable pageRequest) {

		return participantsDao.findByCodigo(codigo, pageRequest);
	}

	@Override
	public Page<Producto> findByDescripcion(String descripcion, Pageable pageRequest) {
		// TODO Auto-generated method stub
		return participantsDao.findByDescripcion(descripcion, pageRequest);
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
<<<<<<< HEAD:Backend/api-productos-gerencia/src/main/java/cl/adasoft/departamento/gerencia/models/services/ProductoServiceImp.java
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
=======
	public Page<Producto> findByPrecio(Double precio, Pageable pageRequest) {
		// TODO Auto-generated method stub
		return participantsDao.findByPrecio(precio, pageRequest);
>>>>>>> hai:Backend/api-productos-gerencia/src/main/java/cl/adasoft/productos/gerencia/models/services/ProductoServiceImp.java
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findByCategoria(String categoria, Pageable pageable) {

		return participantsDao.findByCategoria(categoria, pageable);
	}

	@Override
<<<<<<< HEAD:Backend/api-productos-gerencia/src/main/java/cl/adasoft/departamento/gerencia/models/services/ProductoServiceImp.java
	public Page<Producto> findByDescripcion(String descripcion, Pageable pageable) {
		return participantsDao.findByDescripcion(descripcion, pageable);
=======
	@Transactional
	public Producto save(Producto participant) {

		return participantsDao.save(participant);
>>>>>>> hai:Backend/api-productos-gerencia/src/main/java/cl/adasoft/productos/gerencia/models/services/ProductoServiceImp.java
	}

}
