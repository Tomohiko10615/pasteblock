package com.pasteblock.pasteblock.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Servicio;

public interface IServicioDao extends PagingAndSortingRepository<Servicio, Long> {

}
