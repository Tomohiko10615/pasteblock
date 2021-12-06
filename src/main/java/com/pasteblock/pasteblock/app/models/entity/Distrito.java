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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="distritos")
public class Distrito implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy="distrito", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DistritoPorBlocker> blockers;
	
	public Distrito() {
		blockers = new ArrayList<DistritoPorBlocker>();
	}
	
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DistritoPorBlocker> getBlockers() {
		return blockers;
	}

	public void setBlockers(List<DistritoPorBlocker> blockers) {
		this.blockers = blockers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
