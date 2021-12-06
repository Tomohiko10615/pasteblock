package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "contratos")
public class Contrato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Servicio servicio;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Blocker blocker;

	@Column(name = "costo_final")
	private Float costoFinal;

	@Column(name = "calificacion_blocker")
	private Integer calificacionBlocker;

	@Column(name = "calificacion_usuario")
	private Integer calificacionUsuario;

	@Column(name = "comentario_blocker")
	private String comentarioBlocker;

	@Column(name = "comentario_usuario")
	private String comentarioUsuario;

	@Column(name = "ha_finalizado")
	private Boolean haFinalizado;

	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@Column(name = "fecha_final")
	@Temporal(TemporalType.DATE)
	private Date fechaFinal;

	@Column(name = "confirmacion_usuario")
	private Boolean confirmacionUsuario;

	@Column(name = "culminacion_blocker")
	private Boolean culminacionBlocker;

	@Column(name = "observaciones_usuario")
	private String observacionesUsuario;

	@Column(name = "observaciones_blocker")
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

	public Integer getCalificacionUsuario() {
		return calificacionUsuario;
	}

	public void setCalificacionUsuario(Integer calificacionUsuario) {
		this.calificacionUsuario = calificacionUsuario;
	}

	public String getComentarioBlocker() {
		return comentarioBlocker;
	}

	public void setComentarioBlocker(String comentarioBlocker) {
		this.comentarioBlocker = comentarioBlocker;
	}

	public String getComentarioUsuario() {
		return comentarioUsuario;
	}

	public void setComentarioUsuario(String comentarioUsuario) {
		this.comentarioUsuario = comentarioUsuario;
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

	public Boolean getConfirmacionUsuario() {
		return confirmacionUsuario;
	}

	public void setConfirmacionUsuario(Boolean confirmacionUsuario) {
		this.confirmacionUsuario = confirmacionUsuario;
	}

	public Boolean getCulminacionBlocker() {
		return culminacionBlocker;
	}

	public void setCulminacionBlocker(Boolean culminacionBlocker) {
		this.culminacionBlocker = culminacionBlocker;
	}

	public String getObservacionesUsuario() {
		return observacionesUsuario;
	}

	public void setObservacionesUsuario(String observacionesUsuario) {
		this.observacionesUsuario = observacionesUsuario;
	}

	public String getObservacionesBlocker() {
		return observacionesBlocker;
	}

	public void setObservacionesBlocker(String observacionesBlocker) {
		this.observacionesBlocker = observacionesBlocker;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
