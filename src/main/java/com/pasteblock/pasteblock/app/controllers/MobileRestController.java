package com.pasteblock.pasteblock.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasteblock.pasteblock.app.models.dao.IClienteDao;
import com.pasteblock.pasteblock.app.models.entity.Cliente;

@RestController
@RequestMapping("/api")
public class MobileRestController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping({"/clientes/listar", "/clientes"})
	public List<Cliente> index() {
		return clienteDao.findAll();
}
