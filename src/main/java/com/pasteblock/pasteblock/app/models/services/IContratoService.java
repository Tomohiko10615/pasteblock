package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasteblock.pasteblock.app.models.entity.Contrato;

public interface IContratoService {
	
	public List<Contrato> findAll();
	
	public Page<Contrato> findAll(Pageable pageable);
	
	public Contrato findOne(Long id);
	
	public Contrato save(Contrato contrato);
	
	public void delete(Long id);
}
