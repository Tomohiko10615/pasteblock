package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import com.pasteblock.pasteblock.app.models.entity.Servicio;

public interface IServicioService {
	
	public List<Servicio> findAll();
	
	public Servicio findOne(Long id);
	
	public Servicio save(Servicio servicio);
	
	public void delete(Long id);
}
