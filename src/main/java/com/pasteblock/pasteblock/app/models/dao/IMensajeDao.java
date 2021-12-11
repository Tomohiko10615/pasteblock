package com.pasteblock.pasteblock.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Mensaje;

public interface IMensajeDao extends PagingAndSortingRepository<Mensaje, Long> {
	
}
