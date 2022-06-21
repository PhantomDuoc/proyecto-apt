package cl.adasoft.departamento.gerencia.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.adasoft.departamento.gerencia.models.entity.Producto;

public interface IProductoService {
	
	public Page<Producto> findAll(Pageable pageable);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);	
	
	public Optional<Producto> findById(Long id);

	public Page<Producto> findByNombre(String nombre, Pageable pageable);

	public Page<Producto> findByCodigo(Long codigo, Pageable pageable);

	public Page<Producto> findByPrecio(Long precio, Pageable pageable);

	public Page<Producto> findByStock(Long stock, Pageable pageable);

	public Page<Producto> findByCategoria(String categoria, Pageable pageable);

	public Page<Producto> findByDescripcion(String descripcion, Pageable pageable);

}
