package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensajes")
public class Mensaje implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	private Blocker blocker;

	private Float costo;
	private String servicio;

	@Column(name = "tiempo_estimado")
	private Integer tiempoEstimado;

	@Column(name = "mensaje_blocker")
	private String mensajeBlocker;

	@Column(name = "mensaje_usuario")
	private String mensajeUsuario;

	@Column(name = "estado_confirmacion_blocker")
	private Boolean estadoConfirmacionBlocker;

	@Column(name = "estado_confirmacion_usuario")
	private Boolean estadoConfirmacionUsuario;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getClienteId() {
		return cliente;
	}

	public void setClienteId(Cliente cliente) {
		this.cliente = cliente;
	}

	public Blocker getBlockerId() {
		return blocker;
	}

	public void setBlockerId(Blocker blocker) {
		this.blocker = blocker;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Integer getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(Integer tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public String getMensajeBlocker() {
		return mensajeBlocker;
	}

	public void setMensajeBlocker(String mensajeBlocker) {
		this.mensajeBlocker = mensajeBlocker;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

	public Boolean getEstadoConfirmacionBlocker() {
		return estadoConfirmacionBlocker;
	}

	public void setEstadoConfirmacionBlocker(Boolean estadoConfirmacionBlocker) {
		this.estadoConfirmacionBlocker = estadoConfirmacionBlocker;
	}

	public Boolean getEstadoConfirmacionUsuario() {
		return estadoConfirmacionUsuario;
	}

	public void setEstadoConfirmacionUsuario(Boolean estadoConfirmacionUsuario) {
		this.estadoConfirmacionUsuario = estadoConfirmacionUsuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Blocker getBlocker() {
		return blocker;
	}

	public void setBlocker(Blocker blocker) {
		this.blocker = blocker;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
