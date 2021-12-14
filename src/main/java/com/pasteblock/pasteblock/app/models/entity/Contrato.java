package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "contratos")
public class Contrato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Servicio servicio;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	private Blocker blocker;

	@ManyToOne(fetch = FetchType.LAZY)
	private Distrito distrito;

	@Column(name = "costo_final")
	private Float costoFinal;

	@Column(name = "calificacion_blocker")
	private Integer calificacionBlocker;

	@Column(name = "calificacion_cliente")
	private Integer calificacionCliente;

	@Column(name = "comentario_blocker", columnDefinition = "VARCHAR(1000)")
	private String comentarioBlocker;

	@Column(name = "comentario_cliente", columnDefinition = "VARCHAR(1000)")
	private String comentarioCliente;

	@Column(name = "ha_finalizado")
	private Boolean haFinalizado;

	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;

	@Column(name = "fecha_final")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFinal;

	@Column(name = "confirmacion_cliente")
	private Boolean confirmacionCliente;

	@Column(name = "culminacion_blocker")
	private Boolean culminacionBlocker;

	@Column(name = "observaciones_cliente", columnDefinition = "VARCHAR(1000)")
	private String observacionesCliente;

	@Column(name = "observaciones_blocker", columnDefinition = "VARCHAR(1000)")
	private String observacionesBlocker;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
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

	public Float getCostoFinal() {
		return costoFinal;
	}

	public void setCostoFinal(Float costoFinal) {
		this.costoFinal = costoFinal;
	}

	public Integer getCalificacionBlocker() {
		return calificacionBlocker;
	}

	public void setCalificacionBlocker(Integer calificacionBlocker) {
		this.calificacionBlocker = calificacionBlocker;
	}

	public Integer getCalificacionCliente() {
		return calificacionCliente;
	}

	public void setCalificacionCliente(Integer calificacionCliente) {
		this.calificacionCliente = calificacionCliente;
	}

	public String getComentarioBlocker() {
		return comentarioBlocker;
	}

	public void setComentarioBlocker(String comentarioBlocker) {
		this.comentarioBlocker = comentarioBlocker;
	}

	public String getComentarioCliente() {
		return comentarioCliente;
	}

	public void setComentarioCliente(String comentarioCliente) {
		this.comentarioCliente = comentarioCliente;
	}

	public Boolean getHaFinalizado() {
		return haFinalizado;
	}

	public void setHaFinalizado(Boolean haFinalizado) {
		this.haFinalizado = haFinalizado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Boolean getConfirmacionCliente() {
		return confirmacionCliente;
	}

	public void setConfirmacionCliente(Boolean confirmacionCliente) {
		this.confirmacionCliente = confirmacionCliente;
	}

	public Boolean getCulminacionBlocker() {
		return culminacionBlocker;
	}

	public void setCulminacionBlocker(Boolean culminacionBlocker) {
		this.culminacionBlocker = culminacionBlocker;
	}

	public String getObservacionesCliente() {
		return observacionesCliente;
	}

	public void setObservacionesCliente(String observacionesCliente) {
		this.observacionesCliente = observacionesCliente;
	}

	public String getObservacionesBlocker() {
		return observacionesBlocker;
	}

	public void setObservacionesBlocker(String observacionesBlocker) {
		this.observacionesBlocker = observacionesBlocker;
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
