package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pasteblock.pasteblock.app.models.dao.IMensajeDao;
import com.pasteblock.pasteblock.app.models.entity.Mensaje;

@Service
public class MensajeServiceImpl implements IMensajeService {
	
	@Autowired
	private IMensajeDao mensajeDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Mensaje> findAll() {
		return (List<Mensaje>) mensajeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Mensaje findOne(Long id) {
		return mensajeDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Mensaje save(Mensaje mensaje) {
		return mensajeDao.save(mensaje);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		mensajeDao.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Page<Mensaje> findAll(Pageable pageable) {
		return mensajeDao.findAll(pageable);
	}

}
