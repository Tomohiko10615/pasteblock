package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pasteblock.pasteblock.app.models.dao.IServicioDao;
import com.pasteblock.pasteblock.app.models.entity.Servicio;

@Service
public class ServicioServiceImpl implements IServicioService {
	
	@Autowired
	private IServicioDao servicioDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Servicio> findAll() {
		return (List<Servicio>) servicioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio findOne(Long id) {
		return servicioDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Servicio save(Servicio servicio) {
		return servicioDao.save(servicio);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		servicioDao.deleteById(id);
	}

}
