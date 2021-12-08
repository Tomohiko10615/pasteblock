package com.pasteblock.pasteblock.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pasteblock.pasteblock.app.models.entity.Cliente;
import com.pasteblock.pasteblock.app.models.services.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		for (int i = 0; i < clienteService.findAll().size(); i++) {
            clienteService.findAll().get(i).getUsuario().setTiempoRegistrado();
            clienteService.save(clienteService.findAll().get(i));
        }
		
		model.addAttribute("accion", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
		
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("accion", "Crear cliente");
		return "crear";
	}
	
	@PostMapping("/form")
	public String guardar(Cliente cliente) {
		if (cliente.getId() == null) {
			cliente.getUsuario().setTiempoRegistrado();
			clienteService.save(cliente);
		}
		else {
			Cliente clienteActualizado = clienteService.findOne(cliente.getId());
			clienteActualizado.getUsuario().setNombre(cliente.getUsuario().getNombre());
			clienteActualizado.getUsuario().setApellido(cliente.getUsuario().getApellido());
			clienteActualizado.getUsuario().setEmail(cliente.getUsuario().getEmail());
			clienteActualizado.getUsuario().setCelular(cliente.getUsuario().getCelular());
			clienteActualizado.setDireccion(cliente.getDireccion());
			clienteActualizado.setDistrito(cliente.getDistrito());
			clienteActualizado.getUsuario().setFechaRegistro(cliente.getUsuario().getFechaRegistro());
			clienteActualizado.getUsuario().setEstaActivo(cliente.getUsuario().getEstaActivo());
			clienteService.save(clienteActualizado);
		}
		
		return "redirect:listar";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Cliente cliente = null;
		
		if (id > 0) {
			cliente = clienteService.findOne(id);
		} else {
			return "redirect:listar";
		}
		
		model.put("cliente", cliente);
		model.put("accion", "Editar cliente");
		return "crear";
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			clienteService.delete(id);
		}
		
		return "redirect:/clientes/listar";
	}
}

