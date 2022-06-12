package cl.adasoft.departamento.gerencia.models.dao;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.adasoft.departamento.gerencia.models.entity.Pedido;

public interface PedidoDao extends PagingAndSortingRepository<Pedido, Long> {

	@Query("select p from Pedido p where p.codigo=?1")
	public Pedido findByCodigo(Long codigo);
}
