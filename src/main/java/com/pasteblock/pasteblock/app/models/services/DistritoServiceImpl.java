package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pasteblock.pasteblock.app.models.dao.IDistritoDao;
import com.pasteblock.pasteblock.app.models.entity.Distrito;

@Service
public class DistritoServiceImpl implements IDistritoService {
	
	@Autowired
	private IDistritoDao distritoDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Distrito> findAll() {
		return (List<Distrito>) distritoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Distrito findOne(Long id) {
		return distritoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Distrito save(Distrito distrito) {
		return distritoDao.save(distrito);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		distritoDao.deleteById(id);
	}

}
