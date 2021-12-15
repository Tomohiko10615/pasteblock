package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pasteblock.pasteblock.app.models.dao.IBlockerDao;
import com.pasteblock.pasteblock.app.models.entity.Blocker;

@Service
public class BlockerServiceImpl implements IBlockerService {
	
	@Autowired
	private IBlockerDao blockerDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Blocker> findAll() {
		return (List<Blocker>) blockerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Blocker findOne(Long id) {
		return blockerDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Blocker save(Blocker blocker) {
		return blockerDao.save(blocker);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		blockerDao.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Page<Blocker> findAll(Pageable pageable) {
		return blockerDao.findAll(pageable);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Blocker> fetchByIdWithServicioWithDistrito(Long servicioId, Long distritoId, String criterio, Integer orden, Integer max) {
		return blockerDao.fecthByIdWithServicioWithDistrito(servicioId, distritoId, criterio, orden, max);
	}
	
	

}
