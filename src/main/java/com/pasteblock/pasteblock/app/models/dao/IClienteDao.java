package com.pasteblock.pasteblock.app.models.dao;

import java.util.List;

import com.pasteblock.pasteblock.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();

	void save(Cliente cliente);
	
}
