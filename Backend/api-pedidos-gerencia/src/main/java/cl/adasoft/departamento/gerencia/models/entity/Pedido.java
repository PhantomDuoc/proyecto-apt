package cl.adasoft.departamento.gerencia.models.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	@NotBlank
	@Column(name = "lista_productos")
	private List<Producto> lista_productos = new ArrayList<Producto>();

	@NotBlank
	@Column(name = "total")
	private Long total;

	@NotBlank
	@Column(name = "cliente")
	private String cliente;

	@NotBlank
	@Column(name = "direccion")
	private String direccion;

	@NotBlank
	@Column(name = "telefono")
	private String telefono;

	@NotBlank
	@Column(name = "email")
	private String email;

	@NotBlank
	@Column(name = "comentario")
	private String comentario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Pedido(Long id, Long estado, String tiempo_ingreso, String tiempo_estimado,
			String tiempo_entrega) {
		super();
		this.id = id;
		this.estado = estado;
		this.tiempo_ingreso = tiempo_ingreso;
		this.tiempo_estimado = tiempo_estimado;
		this.tiempo_entrega = tiempo_entrega;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", estado=" + estado + ", tiempo_ingreso=" + tiempo_ingreso
				+ ", tiempo_estimado=" + tiempo_estimado + ", tiempo_entrega=" + tiempo_entrega
				+ "]";
	}
}
