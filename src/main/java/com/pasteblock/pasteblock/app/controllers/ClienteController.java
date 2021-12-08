package com.pasteblock.pasteblock.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasteblock.pasteblock.app.models.entity.Cliente;
import com.pasteblock.pasteblock.app.models.services.IClienteService;
import com.pasteblock.pasteblock.app.util.paginator.PageRender;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4);
		
		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		
		for (int i = 0; i < clientes.getContent().size(); i++) {
            clientes.getContent().get(i).getUsuario().setTiempoRegistrado();
            clienteService.save(clientes.getContent().get(i));
        }
		
		PageRender<Cliente> pageRender = new PageRender("/clientes/listar", clientes);
		
		model.addAttribute("accion", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
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
	public String guardar(Cliente cliente, RedirectAttributes flash) {
		if (cliente.getId() == null) {
			cliente.getUsuario().setTiempoRegistrado();
			clienteService.save(cliente);
			flash.addFlashAttribute("success", "Cliente creado con éxito");
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
			flash.addFlashAttribute("success", "Cliente actualizado con éxito");
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
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con éxito");
		}
		
		return "redirect:/clientes/listar";
	}
}

