package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "blockers")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Blocker implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Usuario usuario;

	@Column(columnDefinition="TEXT")
	private String presentacion;

	@Column(name = "numero_calificaciones")
	private Integer numeroCalificaciones;
	
	private Float reputacion;
	private String foto;
	private Boolean disponible;
	
	@PrePersist
	public void prePersist() {
		disponible = true;
		numeroCalificaciones = 0;
		numeroTrabajosCulminados = 0;
	}
	
	@OneToMany(mappedBy="blocker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Mensaje> mensajes;
	
	@OneToMany(mappedBy="blocker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contrato> contratos;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Servicio> servicios = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Distrito> distritos;

	public Blocker() {
		mensajes = new ArrayList<Mensaje>();
		contratos = new ArrayList<Contrato>();
		distritos = new ArrayList<Distrito>();
	}

	@Column(name = "es_nuevo")
	private Boolean esNuevo;

	@Column(name = "trabajos_en_proceso")
	private Integer trabajosEnProceso;

	@Column(name = "numero_trabajos_culminados")
	private Integer numeroTrabajosCulminados;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuarioId(Usuario usuario) {
		this.usuario = usuario;
	}

	public Float getReputacion() {
		return reputacion;
	}

	public void setReputacion(Float reputacion) {
		this.reputacion = reputacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Boolean getEsNuevo() {
		return esNuevo;
	}

	public void setEsNuevo(Boolean esNuevo) {
		this.esNuevo = esNuevo;
	}

	public Integer getTrabajosEnProceso() {
		return trabajosEnProceso;
	}

	public void setTrabajosEnProceso(Integer trabajosEnProceso) {
		this.trabajosEnProceso = trabajosEnProceso;
	}

	public Integer getNumeroTrabajosCulminados() {
		return numeroTrabajosCulminados;
	}

	public void setNumeroTrabajosCulminados(Integer numeroTrabajosCulminados) {
		this.numeroTrabajosCulminados = numeroTrabajosCulminados;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Integer getNumeroCalificaciones() {
		return numeroCalificaciones;
	}

	public void setNumeroCalificaciones(Integer numeroCalificaciones) {
		this.numeroCalificaciones = numeroCalificaciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
