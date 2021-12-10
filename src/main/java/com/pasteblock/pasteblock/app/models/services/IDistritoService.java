package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import com.pasteblock.pasteblock.app.models.entity.Distrito;

public interface IDistritoService {
	
	public List<Distrito> findAll();
	
	public Distrito findOne(Long id);
	
	public Distrito save(Distrito distrito);
	
	public void delete(Long id);
}
