package com.pasteblock.pasteblock.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pasteblock.pasteblock.app.models.dao.IContratoDao;
import com.pasteblock.pasteblock.app.models.entity.Contrato;

@Service
public class ContratoServiceImpl implements IContratoService {
	
	@Autowired
	private IContratoDao contratoDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Contrato> findAll() {
		return (List<Contrato>) contratoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Contrato findOne(Long id) {
		return contratoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Contrato save(Contrato contrato) {
		return contratoDao.save(contrato);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		contratoDao.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Page<Contrato> findAll(Pageable pageable) {
		return contratoDao.findAll(pageable);
	}
	
	public List<Contrato> fetchByClienteId(Long clienteId, Boolean finalizado, Integer inicio, Integer total) {
		return contratoDao.fetchByClienteId(clienteId, finalizado, inicio, total);
	}
	
	public List<Contrato> fetchByBlockerId(Long blockerId, Boolean finalizado, Integer inicio, Integer total) {
		return contratoDao.fetchByBlockerId(blockerId, finalizado, inicio, total);
	}

}
