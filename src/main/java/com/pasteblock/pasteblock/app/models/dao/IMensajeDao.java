package com.pasteblock.pasteblock.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Mensaje;

public interface IMensajeDao extends PagingAndSortingRepository<Mensaje, Long> {
	@Query(value="SELECT * FROM mensajes WHERE cliente_id = ?1 ORDER BY id DESC LIMIT ?2, ?3", nativeQuery = true)
	public List<Mensaje> fetchByClienteId(Long clienteId, Integer inicio, Integer total);
	
	@Query(value="SELECT * FROM mensajes WHERE blocker_id = ?1 ORDER BY id DESC LIMIT ?2, ?3", nativeQuery = true)
	public List<Mensaje> fetchByBlockerId(Long clienteId, Integer inicio, Integer total);
}
