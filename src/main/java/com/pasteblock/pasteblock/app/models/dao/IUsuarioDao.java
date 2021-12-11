package com.pasteblock.pasteblock.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long> {
	
	public Usuario findByEmail(String email);
	
}
