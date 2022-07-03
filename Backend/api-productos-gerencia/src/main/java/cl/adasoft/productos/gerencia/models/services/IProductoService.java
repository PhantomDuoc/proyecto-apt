package cl.adasoft.productos.gerencia.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.adasoft.productos.gerencia.models.entity.Producto;

public interface IProductoService {

	public void delete(Long id);

	public Page<Producto> findAll(Pageable pageable);

	public Page<Producto> findByCategoria(String categoria, Pageable pageRequest);

	public Optional<Producto> findById(Long id);

	public Page<Producto> findByNombre(String nombre, Pageable pageRequest);

	public Page<Producto> findByPrecio(Long precio, Pageable pageRequest);

	public Page<Producto> findByStock(Long stock, Pageable pageRequest);

	public Producto save(Producto persona);
}
