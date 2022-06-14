package cl.adasoft.departamento.gerencia.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.adasoft.departamento.gerencia.models.entity.Producto;

public interface IProductoService {

	public Page<Producto> findAll(Pageable pageable);

	public Producto save(Producto persona);

	public void delete(Long id);

	public Optional<Producto> findById(Long id);

	public Page<Producto> findByNombre(String nombre, Pageable pageRequest);

	public Page<Producto> findByDescripcion(String descripcion, Pageable pageRequest);

	public Page<Producto> findByPrecio(Double precio, Pageable pageRequest);

	public Page<Producto> findByStock(Integer stock, Pageable pageRequest);

	public Page<Producto> findByCategoria(String categoria, Pageable pageRequest);

	public Page<Producto> findByCodigo(String codigo, Pageable pageRequest);
}
