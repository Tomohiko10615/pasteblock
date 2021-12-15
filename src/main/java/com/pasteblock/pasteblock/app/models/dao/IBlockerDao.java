package com.pasteblock.pasteblock.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Blocker;

public interface IBlockerDao extends PagingAndSortingRepository<Blocker, Long> {

	@Query(value="SELECT * FROM blockers INNER JOIN usuarios ON blockers.usuario_id=usuarios.id WHERE blockers.id IN (SELECT DISTINCT blockers.id FROM blockers WHERE id IN (SELECT blockers_id FROM blockers_servicios WHERE servicios_id = ?1)"
			+ "AND blockers.id IN (SELECT blockers.id FROM blockers WHERE blockers.id IN (SELECT blockers_id FROM blockers_distritos WHERE distritos_id = ?2)))"
			+ "AND disponible = TRUE "
			+ "AND usuario_id IN (SELECT usuario_id FROM usuarios WHERE esta_activo = TRUE) "
			+ "ORDER BY"
			+ "(CASE WHEN ?4 = 0 AND ?3 = 'reputacion' THEN reputacion WHEN ?4 = 0 AND ?3 = 'numero_trabajos_culminados' THEN numero_trabajos_culminados WHEN ?4 = 0 AND ?3 = 'fecha_de_registro' THEN fecha_de_registro END) ASC,"
			+ "(CASE WHEN ?4 = 1 AND ?3 = 'reputacion' THEN reputacion WHEN ?4 = 1 AND ?3 = 'numero_trabajos_culminados' THEN numero_trabajos_culminados WHEN ?4 = 1 AND ?3 = 'fecha_de_registro' THEN fecha_de_registro END) DESC "
			+ "LIMIT ?5", nativeQuery = true)
	public List<Blocker> fecthByIdWithServicioWithDistrito(Long servicioId, Long distritoId, String criterio, Integer orden, Integer max);
}
