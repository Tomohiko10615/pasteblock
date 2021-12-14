package com.pasteblock.pasteblock.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pasteblock.pasteblock.app.models.dao.IUsuarioDao;
import com.pasteblock.pasteblock.app.models.entity.Blocker;
import com.pasteblock.pasteblock.app.models.entity.Cliente;
import com.pasteblock.pasteblock.app.models.entity.Distrito;
import com.pasteblock.pasteblock.app.models.entity.Role;
import com.pasteblock.pasteblock.app.models.entity.Servicio;
import com.pasteblock.pasteblock.app.models.entity.Usuario;
import com.pasteblock.pasteblock.app.models.services.IBlockerService;
import com.pasteblock.pasteblock.app.models.services.IClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IBlockerService blockerService;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping("/usuario")
	public Usuario usuario() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Usuario usuarioAuth = usuarioDao.findByEmail(email);
		 
		if (usuarioAuth.getCliente() != null) {
			usuarioAuth.getCliente().setUsuario(null);
			usuarioAuth.getCliente().setMensajes(null);
			usuarioAuth.getCliente().setContratos(null);
		}
		
		return usuarioAuth;
	}
	
	@GetMapping("/listar/{servicio_id}/{distrito_id}")
	public List<Blocker> blockers(@PathVariable(value="servicio_id") Long servicio_id, @PathVariable(value="distrito_id") Long distrito_id) {
		
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String email = auth.getName();
		//Usuario usuarioAuth = usuarioDao.findByEmail(email);
		 
		//Long distrito_id = usuarioAuth.getCliente().getDistritoId();
		
		List <Blocker> blockers = blockerService.fetchByIdWithServicioWithDistrito(servicio_id, distrito_id);
		
		for (Blocker b : blockers) {
			b.setMensajes(null);
			b.setContratos(null);
			b.setServicios(null);
			b.setDistritos(null);
			Usuario usuario = new Usuario();
			usuario.setId(b.getUsuario().getId());
			usuario.setNombre(b.getUsuario().getNombre());
			usuario.setApellido(b.getUsuario().getApellido());
			usuario.setFechaRegistro(b.getUsuario().getFechaRegistro());
			usuario.setTiempoRegistrado();
			b.setUsuario(usuario);
		}
		
		
		
		return blockers;
	}
	
	@PostMapping("/form")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente guardar(@RequestBody @Valid Cliente cliente) {
		if (cliente.getId() == null) {
			List<Role> roles = new ArrayList<Role>();
			cliente.getUsuario().setRoles(roles);
			Role rol = new Role();
			rol.setAuthority("Cliente");
			cliente.getUsuario().getRoles().add(rol);
			cliente.getUsuario().setTiempoRegistrado();
			cliente.getUsuario().setPassword(passwordEncoder.encode(cliente.getUsuario().getPassword()));
			return clienteService.save(cliente);
		}
		else {
			Cliente clienteActualizado = clienteService.findOne(cliente.getId());
			clienteActualizado.getUsuario().setCelular(cliente.getUsuario().getCelular());
			clienteActualizado.setDireccion(cliente.getDireccion());
			clienteActualizado.setDistritoId(cliente.getDistritoId());
			return clienteService.save(clienteActualizado);
		}
	
	}
	
}
