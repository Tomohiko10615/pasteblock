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
			+ "(CASE WHEN ?4 = 0 AND ?3 = 'culminados' THEN numero_trabajos_culminados END) ASC,"
            + "(CASE WHEN ?4 = 0 AND ?3 = 'fecha' THEN fecha_de_registro END) ASC,"
            + "(CASE WHEN ?4 = 0 AND ?3 = 'reputacion' THEN reputacion END) ASC,"
			+ "(CASE WHEN ?4 = 1 AND ?3 = 'culminados' THEN numero_trabajos_culminados END) DESC,"
            + "(CASE WHEN ?4 = 1 AND ?3 = 'fecha' THEN fecha_de_registro END) DESC,"
            + "(CASE WHEN ?4 = 1 AND ?3 = 'reputacion' THEN reputacion END) DESC "
            + "LIMIT ?5, ?6", nativeQuery = true)
	public List<Blocker> fetchByIdWithServicioWithDistrito(Long servicioId, Long distritoId, String criterio, Integer orden, Integer inicio, Integer total);
	
	@Query(value="SELECT COUNT(*) FROM blockers", nativeQuery = true)
	public Integer getTotalBlockers();
	
	@Query(value="SELECT COUNT(*) FROM blockers_distritos INNER JOIN blockers_servicios "
			+ "ON blockers_servicios.blockers_id=blockers_distritos.blockers_id "
			+ "WHERE servicios_id = ?1 AND distritos_id = ?2", nativeQuery = true)
	public Integer getTotalBlockersByServicioAndDistrito(Long servicioId, Long distritoId);
	

}
