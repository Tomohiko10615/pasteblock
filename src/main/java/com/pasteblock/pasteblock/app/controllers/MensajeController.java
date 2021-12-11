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

import com.pasteblock.pasteblock.app.models.entity.Contrato;
import com.pasteblock.pasteblock.app.models.entity.Mensaje;
import com.pasteblock.pasteblock.app.models.services.IMensajeService;
import com.pasteblock.pasteblock.app.util.paginator.PageRender;

@Controller
@RequestMapping("/mensajes")
public class MensajeController {
	
	@Autowired
	private IMensajeService mensajeService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		
		Page<Mensaje> mensajes = mensajeService.findAll(pageRequest);
		
		PageRender<Contrato> pageRender = new PageRender("/mensajes/listar", mensajes);
		
		model.addAttribute("accion", "Mensajes");
		model.addAttribute("mensajes", mensajes);
		model.addAttribute("page", pageRender);
		return "men-listar";
		
	}
	
	@PostMapping("/form")
	public String guardar(Mensaje mensaje, RedirectAttributes flash) {
	
		mensajeService.save(mensaje);
		flash.addFlashAttribute("success", "Mensaje actualizado con éxito");
		
		String redirect = "redirect:ver/" + mensaje.getId(); 
		
		return redirect;
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Mensaje mensaje = null;
		
		if (id > 0) {
			mensaje = mensajeService.findOne(id);
		} else {
			return "redirect:listar";
		}
		
		model.put("mensaje", mensaje);
		model.put("accion", "Editar mensaje");
		return "men-crear";
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id, Model model) {
		Mensaje mensaje = mensajeService.findOne(id);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("accion", "Mensaje");
		return "men-ver";
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			mensajeService.delete(id);
			flash.addFlashAttribute("success", "Mensaje eliminado con éxito");
		}
		
		return "redirect:/mensajes/listar";
	}
}

