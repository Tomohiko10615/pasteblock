package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasteblock.pasteblock.app.models.entity.Mensaje;

public interface IMensajeService {
	
	public List<Mensaje> findAll();
	
	public Page<Mensaje> findAll(Pageable pageable);
	
	public Mensaje findOne(Long id);
	
	public Mensaje save(Mensaje mensaje);
	
	public void delete(Long id);
	
	public List<Mensaje> fecthByClienteId(Long clienteId);
}
