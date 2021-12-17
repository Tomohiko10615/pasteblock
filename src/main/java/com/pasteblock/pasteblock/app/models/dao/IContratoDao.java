package com.pasteblock.pasteblock.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Contrato;

public interface IContratoDao extends PagingAndSortingRepository<Contrato, Long> {
	@Query(value="SELECT * FROM contratos WHERE cliente_id = ?1 AND (ha_finalizado = false OR ha_finalizado = ?2) ORDER BY id DESC LIMIT ?3, ?4", nativeQuery = true)
	public List<Contrato> fetchByClienteId(Long clienteId, Boolean finalizado, Integer inicio, Integer total);
	
	@Query(value="SELECT * FROM contratos WHERE blocker_id = ?1 AND (ha_finalizado = false OR ha_finalizado = ?2) ORDER BY id DESC LIMIT ?3, ?4", nativeQuery = true)
	public List<Contrato> fetchByBlockerId(Long blockerId, Boolean finalizado, Integer inicio, Integer total);
}
