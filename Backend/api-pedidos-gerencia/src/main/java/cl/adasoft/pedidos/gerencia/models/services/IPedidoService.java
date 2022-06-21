package cl.adasoft.pedidos.gerencia.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.adasoft.pedidos.gerencia.models.entity.Pedido;

public interface IPedidoService {
	
	public Page<Pedido> findAll(Pageable pageable);
	
	public Pedido save(Pedido Pedido);
	
	public void delete(Long id);	
	
	public Pedido findByRut(Long rut);
	
	public Optional<Pedido> findById(Long id);

	public Optional<Pedido> findByCodigo(Long codigo);

	public Optional<Pedido> findByEstado(Long estado);

	public Optional<Pedido> findByIdUsuario(Long idUsuario);

	public Optional<Pedido> findByIdRepartidor(String idRepartidor);
}
