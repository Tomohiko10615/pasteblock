package com.pasteblock.pasteblock.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {
	@Query(value="SELECT COUNT(*) FROM clientes", nativeQuery = true)
	public Integer getTotalClientes();
}
