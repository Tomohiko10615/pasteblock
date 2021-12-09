package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="distritos")
public class Distrito implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy = "distritos")
	private List<Blocker> blockers;
	
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
