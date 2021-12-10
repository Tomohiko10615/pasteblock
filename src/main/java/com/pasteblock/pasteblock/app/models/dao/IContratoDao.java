package com.pasteblock.pasteblock.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Contrato;

public interface IContratoDao extends PagingAndSortingRepository<Contrato, Long> {

}
