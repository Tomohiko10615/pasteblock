package com.pasteblock.pasteblock.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.pasteblock.pasteblock.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
