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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Usuario usuario;
	
	private Float reputacion;
	private String direccion;
	private Long distritoId;

	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Mensaje> mensajes;

	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contrato> contratos;
	
	public Cliente() {
		mensajes = new ArrayList<Mensaje>();
		contratos = new ArrayList<Contrato>();
	}

	@Column(name = "numero_servicios_contratados")
	private Integer numeroServiciosContratados;
	
	@PrePersist
	public void prePersist() {
		numeroServiciosContratados = 0;
	}

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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Float getReputacion() {
		return reputacion;
	}

	public void setReputacion(Float reputacion) {
		this.reputacion = reputacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Integer getNumeroServiciosContratados() {
		return numeroServiciosContratados;
	}

	public void setNumeroServiciosContratados(Integer numeroServiciosContratados) {
		this.numeroServiciosContratados = numeroServiciosContratados;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(Long distritoId) {
		this.distritoId = distritoId;
	}

	
	

}
