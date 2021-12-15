package com.pasteblock.pasteblock.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasteblock.pasteblock.app.models.entity.Servicio;
import com.pasteblock.pasteblock.app.models.services.IServicioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	private IServicioService servicioService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Servicio> servicios = servicioService.findAll();
		
		model.addAttribute("accion", "Servicios");
		model.addAttribute("servicios", servicios);
		return "ser-listar";
		
	}
	
	@PostMapping("/form")
	public String guardar(Servicio servicio, RedirectAttributes flash) {
	
		servicioService.save(servicio);
		flash.addFlashAttribute("success", "Servicio actualizado con éxito");
		
		return "redirect:listar/";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Servicio servicio = null;
		
		if (id > 0) {
			servicio = servicioService.findOne(id);
		} else {
			return "redirect:listar";
		}
		
		model.put("servicio", servicio);
		model.put("accion", "Editar servicio");
		return "ser-crear";
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			servicioService.delete(id);
			flash.addFlashAttribute("success", "Servicio eliminado con éxito");
		}
		
		return "redirect:/servicios/listar";
	}
}

