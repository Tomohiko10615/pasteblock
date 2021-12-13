package com.pasteblock.pasteblock.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasteblock.pasteblock.app.models.dao.IClienteDao;
import com.pasteblock.pasteblock.app.models.entity.Cliente;
import com.pasteblock.pasteblock.app.models.entity.Contrato;
import com.pasteblock.pasteblock.app.models.entity.Mensaje;
import com.pasteblock.pasteblock.app.models.entity.Role;
import com.pasteblock.pasteblock.app.models.entity.Usuario;
import com.pasteblock.pasteblock.app.models.services.IClienteService;
import com.pasteblock.pasteblock.app.util.paginator.PageRender;

@RestController
@CrossOrigin(origins = {})
@RequestMapping("/api/clientes")
public class ClientesRestController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/listar")
	public List<Cliente> listar() {
		List<Cliente> clientes = (List<Cliente>) clienteDao.findAll();
		for(Cliente c: clientes){
		    c.setMensajes(null);
		    c.setContratos(null);
		    c.getUsuario().setCliente(null);
		}
		return clientes;
		
	}
	
	@PostMapping("/form")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente guardar(@RequestBody Cliente cliente) {
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
			clienteActualizado.getUsuario().setNombre(cliente.getUsuario().getNombre());
			clienteActualizado.getUsuario().setApellido(cliente.getUsuario().getApellido());
			clienteActualizado.getUsuario().setEmail(cliente.getUsuario().getEmail());
			clienteActualizado.getUsuario().setCelular(cliente.getUsuario().getCelular());
			clienteActualizado.setDireccion(cliente.getDireccion());
			clienteActualizado.setDistrito(cliente.getDistrito());
			clienteActualizado.getUsuario().setFechaRegistro(cliente.getUsuario().getFechaRegistro());
			clienteActualizado.getUsuario().setEstaActivo(cliente.getUsuario().getEstaActivo());
			return clienteService.save(clienteActualizado);
		}
	
	}
	
}
