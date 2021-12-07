package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import com.pasteblock.pasteblock.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findOne(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
}
