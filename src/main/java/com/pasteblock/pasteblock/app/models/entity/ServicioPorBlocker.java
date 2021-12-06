package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="servicios_por_blocker")
public class ServicioPorBlocker implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Blocker blocker;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Servicio servicio;

	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blocker getBlocker() {
		return blocker;
	}

	public void setBlockerId(Blocker blocker) {
		this.blocker = blocker;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicioId(Servicio servicio) {
		this.servicio = servicio;
	}

	public void setBlocker(Blocker blocker) {
		this.blocker = blocker;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
