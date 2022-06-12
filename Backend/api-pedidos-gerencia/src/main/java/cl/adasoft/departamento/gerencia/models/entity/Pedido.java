package cl.adasoft.departamento.gerencia.models.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "codigo")
	private Long codigo;

	@NotBlank
	@Column(name = "estado")
	private Long estado;

	@NotBlank
	@Column(name = "tiempo_ingreso")
	private String tiempo_ingreso;

	@NotBlank
	@Column(name = "tiempo_estimado")
	private String tiempo_estimado;

	@NotBlank
	@Column(name = "tiempo_entrega")
	private String tiempo_entrega;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	@RestResource(path = "idUsuario", rel = "usuario")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "id_repartidor")
	@RestResource(path = "idRepartidor", rel = "repartidor")
	private Usuario repartidor;

	@OneToMany(name= "productos", mappedBy = "pedido")
	@RestResource(path = "productos", rel = "productos")
	private List<Producto> productos;

	

	public Usuario getUsuario() {
		return usuario;
	}

	public Usuario getRepartidor(){
		return repartidor;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public String getTiempo_ingreso() {
		return tiempo_ingreso;
	}

	public void setTiempo_ingreso(String tiempo_ingreso) {
		this.tiempo_ingreso = tiempo_ingreso;
	}

	public String getTiempo_estimado() {
		return tiempo_estimado;
	}

	public void setTiempo_estimado(String tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}

	public String getTiempo_entrega() {
		return tiempo_entrega;
	}

	public void setTiempo_entrega(String tiempo_entrega) {
		this.tiempo_entrega = tiempo_entrega;
	}

	public Pedido() {
		super();
	}

	public Pedido(Long id, Long codigo, Long estado, String tiempo_ingreso, String tiempo_estimado,
			String tiempo_entrega, Usuario usuario) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.estado = estado;
		this.tiempo_ingreso = tiempo_ingreso;
		this.tiempo_estimado = tiempo_estimado;
		this.tiempo_entrega = tiempo_entrega;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", estado=" + estado + ", tiempo_ingreso=" + tiempo_ingreso
				+ ", tiempo_estimado=" + tiempo_estimado + ", tiempo_entrega=" + tiempo_entrega + ", usuario=" + usuario
				+ "]";
	}
}
