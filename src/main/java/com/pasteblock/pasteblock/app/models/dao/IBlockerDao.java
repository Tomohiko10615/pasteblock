package com.pasteblock.pasteblock.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Blocker;

public interface IBlockerDao extends PagingAndSortingRepository<Blocker, Long> {

	@Query(value="SELECT * FROM blockers WHERE id IN (SELECT DISTINCT id FROM blockers WHERE id IN (SELECT blockers_id FROM blockers_servicios WHERE servicios_id = ?1)"
			+ "AND id IN (SELECT id FROM blockers WHERE blockers.id IN (SELECT blockers_id FROM blockers_distritos WHERE distritos_id = ?2)))"
			+ "AND disponible = TRUE "
			+ "AND usuario_id IN (SELECT usuario_id FROM usuarios WHERE esta_activo = TRUE) "
			+ "ORDER BY reputacion DESC "
			+ "LIMIT 3", nativeQuery = true)
	public List<Blocker> fecthByIdWithServicioWithDistrito(Long servicio_id, Long distrito_id);
}
