package com.pasteblock.pasteblock.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Mensaje;

public interface IMensajeDao extends PagingAndSortingRepository<Mensaje, Long> {
	@Query(value="SELECT * FROM mensajes WHERE cliente_id = ?1 ORDER BY id DESC", nativeQuery = true)
	public List<Mensaje> fecthByClienteId(Long clienteId);
}
