package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="distritos")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Distrito implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@ManyToMany(mappedBy = "distritos")
	private List<Blocker> blockers;
	
	@OneToMany(mappedBy="distrito", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contrato> contratos;
	
	public Distrito() {
		blockers = new ArrayList<Blocker>();
	}
	
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Blocker> getBlockers() {
		return blockers;
	}

	public void setBlockers(List<Blocker> blockers) {
		this.blockers = blockers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
