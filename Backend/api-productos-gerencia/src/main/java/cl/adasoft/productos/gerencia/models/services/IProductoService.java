package cl.adasoft.productos.gerencia.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.adasoft.productos.gerencia.models.entity.Producto;

public interface IProductoService {
<<<<<<< HEAD:Backend/api-productos-gerencia/src/main/java/cl/adasoft/departamento/gerencia/models/services/IProductoService.java
	
	public Page<Producto> findAll(Pageable pageable);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);	
	
=======

	public void delete(Long id);

	public Page<Producto> findAll(Pageable pageable);

	public Page<Producto> findByCategoria(String categoria, Pageable pageRequest);

	public Page<Producto> findByCodigo(String codigo, Pageable pageRequest);

	public Page<Producto> findByDescripcion(String descripcion, Pageable pageRequest);

>>>>>>> hai:Backend/api-productos-gerencia/src/main/java/cl/adasoft/productos/gerencia/models/services/IProductoService.java
	public Optional<Producto> findById(Long id);

	public Page<Producto> findByNombre(String nombre, Pageable pageable);

<<<<<<< HEAD:Backend/api-productos-gerencia/src/main/java/cl/adasoft/departamento/gerencia/models/services/IProductoService.java
	public Page<Producto> findByCodigo(Long codigo, Pageable pageable);

	public Page<Producto> findByPrecio(Long precio, Pageable pageable);
=======
	public Page<Producto> findByPrecio(Double precio, Pageable pageRequest);
>>>>>>> hai:Backend/api-productos-gerencia/src/main/java/cl/adasoft/productos/gerencia/models/services/IProductoService.java

	public Page<Producto> findByStock(Long stock, Pageable pageable);

<<<<<<< HEAD:Backend/api-productos-gerencia/src/main/java/cl/adasoft/departamento/gerencia/models/services/IProductoService.java
	public Page<Producto> findByCategoria(String categoria, Pageable pageable);

	public Page<Producto> findByDescripcion(String descripcion, Pageable pageable);

=======
	public Producto save(Producto persona);
>>>>>>> hai:Backend/api-productos-gerencia/src/main/java/cl/adasoft/productos/gerencia/models/services/IProductoService.java
}
