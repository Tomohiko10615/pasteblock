package com.pasteblock.pasteblock.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pasteblock.pasteblock.app.models.dao.IClienteDao;
import com.pasteblock.pasteblock.app.models.entity.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();;
		model.put("cliente", cliente);
		model.put("titulo", "Crear cliente");
		System.out.println(cliente);
		return "crear";
	}
	
	@PostMapping("/form")
	public String guardar(Cliente cliente) {
		System.out.println(cliente);
		clienteDao.save(cliente);
		return "redirect:listar";
	}
}

