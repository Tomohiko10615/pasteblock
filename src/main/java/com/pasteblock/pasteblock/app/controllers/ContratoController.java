package com.pasteblock.pasteblock.app.controllers;

import java.util.List;
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
import com.pasteblock.pasteblock.app.models.entity.Distrito;
import com.pasteblock.pasteblock.app.models.entity.Servicio;
import com.pasteblock.pasteblock.app.models.services.IContratoService;
import com.pasteblock.pasteblock.app.models.services.IDistritoService;
import com.pasteblock.pasteblock.app.models.services.IServicioService;
import com.pasteblock.pasteblock.app.util.paginator.PageRender;

@Controller
@RequestMapping("/contratos")
public class ContratoController {
	
	@Autowired
	private IServicioService servicioService;
	
	@Autowired
	private IDistritoService distritoService;
	
	@Autowired
	private IContratoService contratoService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		
		Page<Contrato> contratos = contratoService.findAll(pageRequest);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageRender<Contrato> pageRender = new PageRender("/contratos/listar", contratos);
		
		model.addAttribute("accion", "Listado de contratos");
		model.addAttribute("contratos", contratos);
		model.addAttribute("page", pageRender);
		return "con-listar";
		
	}
	
	@PostMapping("/form")
	public String guardar(Contrato contrato, RedirectAttributes flash) {
	
		contratoService.save(contrato);
		flash.addFlashAttribute("success", "Contrato actualizado con éxito");
		
		String redirect = "redirect:ver/" + contrato.getId(); 
		
		return redirect;
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Contrato contrato = null;
		
		if (id > 0) {
			contrato = contratoService.findOne(id);
		} else {
			return "redirect:listar";
		}
		
		List<Distrito> distritos = distritoService.findAll();
		List<Servicio> servicios = servicioService.findAll();
		model.put("contrato", contrato);
		model.put("distritos", distritos);
		model.put("servicios", servicios);
		model.put("accion", "Editar contrato");
		return "con-crear";
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id, Model model) {
		Contrato contrato = contratoService.findOne(id);
		List<Servicio> servicios = servicioService.findAll();
		model.addAttribute("contrato", contrato);
		model.addAttribute("servicios", servicios);
		model.addAttribute("accion", "Detalles del contrato");
		return "con-ver";
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			contratoService.delete(id);
			flash.addFlashAttribute("success", "Contrato eliminado con éxito");
		}
		
		return "redirect:/contratos/listar";
	}
}

