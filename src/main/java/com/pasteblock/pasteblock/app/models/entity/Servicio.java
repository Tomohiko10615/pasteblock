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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "servicios")
public class Servicio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_servicio")
	private String tipoServicio;

	@Column(name = "costo_estimado_minimo")
	private Float costoEstimadoMinimo;

	@Column(name = "costo_estimado_maximo")
	private Float costoEstimadoMaximo;

	@ManyToMany(mappedBy = "servicios")
	private List<Blocker> blockers;
	
	public Servicio() {
		blockers = new ArrayList<Blocker>();
	}

	@OneToMany(mappedBy = "servicio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contrato> contratos;
	
	@OneToMany(mappedBy = "servicio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Mensaje> mensajes;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Float getCostoEstimadoMinimo() {
		return costoEstimadoMinimo;
	}

	public void setCostoEstimadoMinimo(Float costoEstimadoMinimo) {
		this.costoEstimadoMinimo = costoEstimadoMinimo;
	}

	public Float getCostoEstimadoMaximo() {
		return costoEstimadoMaximo;
	}

	public void setCostoEstimadoMaximo(Float costoEstimadoMaximo) {
		this.costoEstimadoMaximo = costoEstimadoMaximo;
	}

	public List<Blocker> getBlockers() {
		return blockers;
	}

	public void setBlockers(List<Blocker> blockers) {
		this.blockers = blockers;
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

}
