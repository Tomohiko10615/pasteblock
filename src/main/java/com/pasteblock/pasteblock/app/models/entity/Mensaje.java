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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="mensajes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Mensaje implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	private Blocker blocker;

	private Float costo;

	@ManyToOne(fetch = FetchType.LAZY)
	private Servicio servicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Distrito distrito;

	@Column(name = "tiempo_estimado")
	private Integer tiempoEstimado;

	@Column(name = "mensaje_blocker", columnDefinition = "VARCHAR(1000)")
	private String mensajeBlocker;

	@Column(name = "mensaje_cliente", columnDefinition = "VARCHAR(1000)")
	private String mensajeCliente;

	@Column(name = "estado_confirmacion_blocker")
	private Boolean estadoConfirmacionBlocker;

	@Column(name = "estado_confirmacion_cliente")
	private Boolean estadoConfirmacionCliente;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
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

	public String getMensajeCliente() {
		return mensajeCliente;
	}

	public void setMensajeUsuario(String mensajeCliente) {
		this.mensajeCliente = mensajeCliente;
	}

	public Boolean getEstadoConfirmacionBlocker() {
		return estadoConfirmacionBlocker;
	}

	public void setEstadoConfirmacionBlocker(Boolean estadoConfirmacionBlocker) {
		this.estadoConfirmacionBlocker = estadoConfirmacionBlocker;
	}

	public Boolean getEstadoConfirmacionCliente() {
		return estadoConfirmacionCliente;
	}

	public void setEstadoConfirmacionCliente(Boolean estadoConfirmacionCliente) {
		this.estadoConfirmacionCliente = estadoConfirmacionCliente;
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

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
