package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasteblock.pasteblock.app.models.entity.Blocker;

public interface IBlockerService {
	
	public List<Blocker> findAll();
	
	public Page<Blocker> findAll(Pageable pageable);
	
	public Blocker findOne(Long id);
	
	public Blocker save(Blocker blocker);
	
	public void delete(Long id);
	
	public List<Blocker> fetchByIdWithServicioWithDistrito(Long servicioId, Long distritoId, String criterio, Integer orden, Integer inicio, Integer total);
	
	public Integer getTotalBlockers();
	
	public Integer getTotalBlockersByServicioAndDistrito(Long servicioId, Long distritoId);
}
