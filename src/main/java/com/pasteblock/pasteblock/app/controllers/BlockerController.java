package com.pasteblock.pasteblock.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasteblock.pasteblock.app.models.entity.Blocker;
import com.pasteblock.pasteblock.app.models.entity.Distrito;
import com.pasteblock.pasteblock.app.models.entity.Servicio;
import com.pasteblock.pasteblock.app.models.services.IBlockerService;
import com.pasteblock.pasteblock.app.models.services.IDistritoService;
import com.pasteblock.pasteblock.app.models.services.IServicioService;
import com.pasteblock.pasteblock.app.util.paginator.PageRender;

@Controller
@RequestMapping("/blockers")
public class BlockerController {
	
	@Autowired
	private IBlockerService blockerService;
	
	@Autowired
	private IServicioService servicioService;
	
	@Autowired
	private IDistritoService distritoService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		
		Page<Blocker> blockers = blockerService.findAll(pageRequest);
		
		for (int i = 0; i < blockers.getContent().size(); i++) {
            blockers.getContent().get(i).getUsuario().setTiempoRegistrado();
            blockerService.save(blockers.getContent().get(i));
        }
		
		PageRender<Blocker> pageRender = new PageRender("/blockers/listar", blockers);
		
		model.addAttribute("accion", "Listado de blockers");
		model.addAttribute("blockers", blockers);
		model.addAttribute("page", pageRender);
		return "bl-listar";
		
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Blocker blocker = new Blocker();
		List<Servicio> servicios = servicioService.findAll();
		List<Distrito> distritos = distritoService.findAll();
		model.put("blocker", blocker);
		model.put("servicios", servicios);
		model.put("distritos", distritos);
		model.put("accion", "Crear blocker");
		return "bl-crear";
	}
	
	@PostMapping("/form")
	public String guardar(Blocker blocker, @RequestParam("file") MultipartFile foto, RedirectAttributes flash) {
		
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				blocker.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (blocker.getId() == null) {
			blocker.getUsuario().setTiempoRegistrado();
			blockerService.save(blocker);
			flash.addFlashAttribute("success", "Blocker creado con éxito");
		}
		else {
			Blocker blockerActualizado = blockerService.findOne(blocker.getId());
			blockerActualizado.getUsuario().setNombre(blocker.getUsuario().getNombre());
			blockerActualizado.getUsuario().setApellido(blocker.getUsuario().getApellido());
			blockerActualizado.getUsuario().setEmail(blocker.getUsuario().getEmail());
			blockerActualizado.getUsuario().setCelular(blocker.getUsuario().getCelular());
			if (blocker.getFoto() != null) {
				blockerActualizado.setFoto(blocker.getFoto());
			}
			blockerActualizado.setPresentacion(blocker.getPresentacion());
			blockerActualizado.setDisponible(blocker.getDisponible());
			blockerActualizado.setDisponible(blocker.getDisponible());
			blockerActualizado.setServicios(blocker.getServicios());
			blockerActualizado.setDistritos(blocker.getDistritos());
			blockerActualizado.getUsuario().setFechaRegistro(blocker.getUsuario().getFechaRegistro());
			blockerActualizado.getUsuario().setEstaActivo(blocker.getUsuario().getEstaActivo());
			blockerService.save(blockerActualizado);
			flash.addFlashAttribute("success", "Blocker actualizado con éxito");
		}
		
		String redirect = "redirect:ver/" + blocker.getId(); 
		
		return redirect;
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Blocker blocker = null;
		
		if (id > 0) {
			blocker = blockerService.findOne(id);
		} else {
			return "redirect:listar";
		}
		
		List<Distrito> distritos = distritoService.findAll();
		List<Servicio> servicios = servicioService.findAll();
		model.put("distritos", distritos);
		model.put("servicios", servicios);
		model.put("blocker", blocker);
		model.put("accion", "Editar blocker");
		return "bl-crear";
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id, Model model) {
		Blocker blocker = blockerService.findOne(id);
		List<Servicio> servicios = servicioService.findAll();
		model.addAttribute("servicios", servicios);
		model.addAttribute("blocker", blocker);
		model.addAttribute("accion", "Perfil del blocker");
		return "bl-ver";
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			blockerService.delete(id);
			flash.addFlashAttribute("success", "Blocker eliminado con éxito");
		}
		
		return "redirect:/blockers/listar";
	}
}

