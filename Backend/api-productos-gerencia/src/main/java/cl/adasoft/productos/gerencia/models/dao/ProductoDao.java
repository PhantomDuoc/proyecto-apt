package cl.adasoft.productos.gerencia.models.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.adasoft.productos.gerencia.models.entity.Producto;

public interface ProductoDao extends PagingAndSortingRepository<Producto, Long> {

<<<<<<< HEAD:Backend/api-productos-gerencia/src/main/java/cl/adasoft/departamento/gerencia/models/dao/ProductoDao.java
	@Query("select p from Producto p where p.id=?1")
	public Optional<Producto> findById(Long id);

	@Query("select p from Producto p where p.stock like %?1%")
	public Page<Producto> findByStock(Long cantidad, org.springframework.data.domain.Pageable pageRequest);

	@Query("select p from Producto p where p.descripcion like %?1%")
	public Page<Producto> findByDescripcion(String descripcion, org.springframework.data.domain.Pageable pageRequest);

	@Query("select p from Producto p where p.nombre like %?1%")
	public Page<Producto> findByNombre(String nombre, org.springframework.data.domain.Pageable pageRequest);
=======
	@Query("select p from Producto p where p.categoria like %?1%")
	public Page<Producto> findByCategoria(String categoria, org.springframework.data.domain.Pageable pageRequest);
>>>>>>> hai:Backend/api-productos-gerencia/src/main/java/cl/adasoft/productos/gerencia/models/dao/ProductoDao.java

	@Query("select p from Producto p where p.codigo like %?1%")
	public Page<Producto> findByCodigo(Long codigo, org.springframework.data.domain.Pageable pageRequest);

	@Query("select p from Producto p where p.descripcion like %?1%")
	public Page<Producto> findByDescripcion(String descripcion, org.springframework.data.domain.Pageable pageRequest);

	@Query("select p from Producto p where p.id=?1")
	public Optional<Producto> findById(Long id);

	@Query("select p from Producto p where p.nombre like %?1%")
	public Page<Producto> findByNombre(String nombre, org.springframework.data.domain.Pageable pageRequest);

	@Query("select p from Producto p where p.nombre like %?1%")
	public Page<Producto> findByNombreContaining(org.springframework.data.domain.Pageable pageRequest, String name);

	@Query("select p from Producto p where p.precio like %?1%")
    public Page<Producto> findByPrecio(Long precio, org.springframework.data.domain.Pageable pageRequest);

	@Query("select p from Producto p where p.stock like %?1%")
	public Page<Producto> findByStock(Integer cantidad, org.springframework.data.domain.Pageable pageRequest);
}
