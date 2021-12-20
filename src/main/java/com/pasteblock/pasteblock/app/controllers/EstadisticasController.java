package com.pasteblock.pasteblock.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pasteblock.pasteblock.app.models.dao.IBlockerDao;
import com.pasteblock.pasteblock.app.models.dao.IClienteDao;
import com.pasteblock.pasteblock.app.models.dao.IContratoDao;
import com.pasteblock.pasteblock.app.models.dao.IMensajeDao;
import com.pasteblock.pasteblock.app.models.dao.IUsuarioDao;
import com.pasteblock.pasteblock.app.models.entity.Distrito;
import com.pasteblock.pasteblock.app.models.entity.Servicio;
import com.pasteblock.pasteblock.app.models.services.IDistritoService;
import com.pasteblock.pasteblock.app.models.services.IServicioService;

@Controller

public class EstadisticasController {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IBlockerDao blockerDao;
	
	@Autowired
	private IMensajeDao mensajeDao;
	
	@Autowired
	private IContratoDao contratoDao;
	
	@Autowired
	private IServicioService servicioService;
	
	@Autowired
	private IDistritoService distritoService;
	
	@GetMapping("/estadisticas")
	public String index(Model model) {
		Integer totalUsuarios = usuarioDao.getTotalUsuarios();
		Integer totalClientes = clienteDao.getTotalClientes();
		Integer totalBlockers = blockerDao.getTotalBlockers();
		Integer totalMensajes = mensajeDao.getTotalMensajes();
		Integer totalContratos = contratoDao.getTotalContratos();
		
		List<Servicio> servicios = servicioService.findAll();
		List<Distrito> distritos = distritoService.findAll();
		
		Map<String, Map<String, Integer>> blockersPorServiciosYDistrito = new HashMap<>();

		for (long servicioId = 1; servicioId <= servicios.size(); servicioId++) {
			for (long distritoId = 1; distritoId <= distritos.size(); distritoId++) {
				blockersPorServiciosYDistrito.computeIfAbsent(servicioService.findOne(servicioId).getTipoServicio(),
				ignored -> new HashMap<String, Integer>())
				.put(distritos.get((int) (distritoId - 1)).getNombre(), blockerDao.getTotalBlockersByServicioAndDistrito(servicioId, distritoId));
				 
			}		
		}
		
		model.addAttribute("accion", "Estadísticas");
		model.addAttribute("totalUsuarios", totalUsuarios);
		model.addAttribute("totalClientes", totalClientes);
		model.addAttribute("totalBlockers", totalBlockers);
		model.addAttribute("totalMensajes", totalMensajes);
		model.addAttribute("totalContratos", totalContratos);
		model.addAttribute("blockersPorServiciosYDistrito", blockersPorServiciosYDistrito);
		return "estadisticas";
	}
}
