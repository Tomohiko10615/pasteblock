package com.pasteblock.pasteblock.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pasteblock.pasteblock.app.DueScheduler;
import com.pasteblock.pasteblock.app.models.dao.IUsuarioDao;
import com.pasteblock.pasteblock.app.models.entity.Blocker;
import com.pasteblock.pasteblock.app.models.entity.Cliente;
import com.pasteblock.pasteblock.app.models.entity.Contrato;
import com.pasteblock.pasteblock.app.models.entity.Distrito;
import com.pasteblock.pasteblock.app.models.entity.Mensaje;
import com.pasteblock.pasteblock.app.models.entity.Role;
import com.pasteblock.pasteblock.app.models.entity.Servicio;
import com.pasteblock.pasteblock.app.models.entity.Usuario;
import com.pasteblock.pasteblock.app.models.services.IBlockerService;
import com.pasteblock.pasteblock.app.models.services.IClienteService;
import com.pasteblock.pasteblock.app.models.services.IContratoService;
import com.pasteblock.pasteblock.app.models.services.IDistritoService;
import com.pasteblock.pasteblock.app.models.services.IMensajeService;
import com.pasteblock.pasteblock.app.models.services.IServicioService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IBlockerService blockerService;

	@Autowired
	private IMensajeService mensajeService;

	@Autowired
	private IServicioService servicioService;

	@Autowired
	private IContratoService contratoService;

	@Autowired
	private IDistritoService distritoService;

	@Autowired
	private IUsuarioDao usuarioDao;
	
	//@Autowired
	//private DueScheduler dueScheduler;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public class Main {
		public static void setNullFields(Usuario usuarioAuth) {
			if (usuarioAuth.getCliente() != null) {
				usuarioAuth.getCliente().setUsuario(null);
				usuarioAuth.getCliente().setMensajes(null);
				usuarioAuth.getCliente().setContratos(null);
			}

			if (usuarioAuth.getBlocker() != null) {
				usuarioAuth.getBlocker().setUsuario(null);
				usuarioAuth.getBlocker().setMensajes(null);
				usuarioAuth.getBlocker().setContratos(null);

				for (Servicio s : usuarioAuth.getBlocker().getServicios()) {
					s.setBlockers(null);
					s.setContratos(null);
				}

				for (Distrito d : usuarioAuth.getBlocker().getDistritos())
					d.setBlockers(null);

			}
		}

		public static void setNullFields(Blocker blocker) {
			blocker.setContratos(null);
			blocker.setDistritos(null);
			for (Servicio s : blocker.getServicios()) {
				s.setBlockers(null);
				s.setContratos(null);
			}
			blocker.setMensajes(null);
			blocker.getUsuario().setBlocker(null);
			Usuario usuario = new Usuario();
			usuario.setId(blocker.getUsuario().getId());
			usuario.setNombre(blocker.getUsuario().getNombre());
			usuario.setApellido(blocker.getUsuario().getApellido());
			usuario.setCelular(blocker.getUsuario().getCelular());
			usuario.setFechaRegistro(blocker.getUsuario().getFechaRegistro());
			usuario.setTiempoRegistrado();
			blocker.setUsuario(usuario);
		}

		public static void setNullFields(Cliente cliente) {
			cliente.setContratos(null);
			cliente.setMensajes(null);
			cliente.getUsuario().setBlocker(null);
			Usuario usuario = new Usuario();
			usuario.setId(cliente.getUsuario().getId());
			usuario.setNombre(cliente.getUsuario().getNombre());
			usuario.setApellido(cliente.getUsuario().getApellido());
			usuario.setCelular(cliente.getUsuario().getCelular());
			usuario.setFechaRegistro(cliente.getUsuario().getFechaRegistro());
			usuario.setTiempoRegistrado();
			cliente.setUsuario(usuario);
		}

		public static void setNullFields(Mensaje mensaje) {
			mensaje.getCliente().setMensajes(null);
			mensaje.getCliente().setContratos(null);
			mensaje.getCliente().getUsuario().setCliente(null);
			mensaje.getBlocker().getUsuario().setBlocker(null);
			mensaje.getBlocker().setMensajes(null);
			mensaje.getBlocker().setServicios(null);
			mensaje.getBlocker().setContratos(null);
			mensaje.getBlocker().setDistritos(null);
			mensaje.getServicio().setBlockers(null);
			mensaje.getServicio().setContratos(null);
			mensaje.getDistrito().setBlockers(null);
		}

		public static void setNullFields(Contrato contrato) {
			contrato.getCliente().setMensajes(null);
			contrato.getCliente().getUsuario().setCliente(null);
			contrato.getCliente().setContratos(null);
			contrato.getBlocker().getUsuario().setBlocker(null);
			contrato.getBlocker().setMensajes(null);
			contrato.getBlocker().setServicios(null);
			contrato.getBlocker().setContratos(null);
			contrato.getBlocker().setDistritos(null);
			contrato.getServicio().setBlockers(null);
			contrato.getServicio().setContratos(null);
			contrato.getDistrito().setBlockers(null);
		}

		public static void setNullFields(Servicio servicio) {
			servicio.setBlockers(null);
			servicio.setContratos(null);
		}

		public static void setNullFields(Distrito distrito) {
			distrito.setBlockers(null);
			distrito.setContratos(null);
		}

	}

	@GetMapping("/usuario")
	public Usuario usuario() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Usuario usuarioAuth = usuarioDao.findByEmail(email);

		Main.setNullFields(usuarioAuth);

		return usuarioAuth;
	}

	@GetMapping("/blocker/{blockerId}")
	public Blocker blocker(@PathVariable(value = "blockerId") Long blockerId) {

		Blocker blocker = blockerService.findOne(blockerId);

		Main.setNullFields(blocker);

		return blocker;
	}

	@GetMapping("/listar/{servicioId}/{distritoId}")
	public List<Blocker> blockers(
			@PathVariable(value = "servicioId") Long servicioId,
			@PathVariable(value = "distritoId") Long distritoId,
			@RequestParam(value = "criterio", defaultValue = "reputacion") String criterio,
			@RequestParam(value = "orden") Integer orden, @RequestParam(value = "inicio") Integer inicio,
			@RequestParam(value = "total") Integer total) {

		List<Blocker> blockers = blockerService.fetchByIdWithServicioWithDistrito(servicioId, distritoId, criterio,
				orden, inicio, total);

		for (Blocker b : blockers) {
			Main.setNullFields(b);
		}

		return blockers;
	}

	@PostMapping("/cliente/form")
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

		} else {

			Cliente clienteActualizado = clienteService.findOne(cliente.getId());
			clienteActualizado.getUsuario().setCelular(cliente.getUsuario().getCelular());
			clienteActualizado.setDireccion(cliente.getDireccion());
			clienteActualizado.setDistritoId(cliente.getDistritoId());

			return clienteService.save(clienteActualizado);
		}

	}

	@PostMapping("/blocker/form")
	@ResponseStatus(HttpStatus.CREATED)
	public Blocker guardar(@RequestBody @Valid Blocker blocker, @RequestParam("file") MultipartFile foto) {

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
			List<Role> roles = new ArrayList<Role>();
			blocker.getUsuario().setRoles(roles);
			Role rol = new Role();
			rol.setAuthority("Blocker");
			blocker.getUsuario().getRoles().add(rol);
			blocker.getUsuario().setTiempoRegistrado();

			blocker.getUsuario().setPassword(passwordEncoder.encode(blocker.getUsuario().getPassword()));

			return blockerService.save(blocker);

		} else {

			Blocker blockerActualizado = blockerService.findOne(blocker.getId());
			blockerActualizado.getUsuario().setCelular(blocker.getUsuario().getCelular());

			if (blocker.getFoto() != null)
				blockerActualizado.setFoto(blocker.getFoto());

			blockerActualizado.setPresentacion(blocker.getPresentacion());
			blockerActualizado.setDisponible(blocker.getDisponible());
			blockerActualizado.setServicios(blocker.getServicios());
			blockerActualizado.setDistritos(blocker.getDistritos());

			return blockerService.save(blockerActualizado);

		}
	}

	@GetMapping("/contacto/{servicioId}/{blockerId}/{distritoId}")
	public Mensaje contacto(@PathVariable(value = "blockerId") Long blockerId,
			@PathVariable(value = "servicioId") Long servicioId, @PathVariable(value = "distritoId") Long distritoId) {

		Mensaje mensaje = new Mensaje();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Usuario usuarioAuth = usuarioDao.findByEmail(email);

		mensaje.setBlocker(blockerService.findOne(blockerId));

		Main.setNullFields(mensaje.getBlocker());

		mensaje.setCliente(clienteService.findOne(usuarioAuth.getCliente().getId()));

		Main.setNullFields(mensaje.getCliente());

		mensaje.setServicio(servicioService.findOne(servicioId));

		Main.setNullFields(mensaje.getServicio());

		mensaje.setDistrito(distritoService.findOne(distritoId));

		Main.setNullFields(mensaje.getDistrito());

		return mensaje;
	}

	@PostMapping("/enviar")
	@ResponseStatus(HttpStatus.CREATED)
	public Mensaje enviar(
			@RequestParam(value = "estadoCliente", defaultValue = "null", required = false) Boolean estadoCliente,
			@RequestParam(value = "estadoBlocker", defaultValue = "null", required = false) Boolean estadoBlocker,
			@RequestBody @Valid Mensaje mensaje) {

		if (mensajeService.findOne(mensaje.getId()) != null) {

			Mensaje mensajeActualizado = mensajeService.findOne(mensaje.getId());
			mensajeActualizado.setEstadoConfirmacionCliente(estadoCliente);
			mensajeActualizado.setEstadoConfirmacionBlocker(estadoBlocker);
			mensajeActualizado.setMensajeBlocker(mensaje.getMensajeBlocker());
			mensajeActualizado.setTiempoEstimado(mensaje.getTiempoEstimado());
			mensajeActualizado.setCosto(mensaje.getCosto());

			return mensajeService.save(mensajeActualizado);

		} else
			return mensajeService.save(mensaje);

	}

	@GetMapping("cliente/inbox")
	public List<Mensaje> clienteInbox(@RequestParam(name = "inicio", defaultValue = "0") Integer inicio,
			@RequestParam(name = "total", defaultValue = "3") Integer total) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Usuario usuarioAuth = usuarioDao.findByEmail(email);

		List<Mensaje> mensajes = mensajeService.fetchByClienteId(usuarioAuth.getCliente().getId(), inicio, total);

		for (Mensaje m : mensajes)
			Main.setNullFields(m);

		return mensajes;
	}

	@GetMapping("cliente/inbox/{mensajeId}")
	public Mensaje clienteInbox(@PathVariable(value = "mensajeId") Long mensajeId) {

		Mensaje mensaje = mensajeService.findOne(mensajeId);
		Main.setNullFields(mensaje);

		return mensaje;

	}

	@GetMapping("blocker/inbox")
	public List<Mensaje> blockerInbox(@RequestParam(name = "inicio", defaultValue = "0") Integer inicio,
			@RequestParam(name = "total", defaultValue = "3") Integer total) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Usuario usuarioAuth = usuarioDao.findByEmail(email);

		List<Mensaje> mensajes = mensajeService.fetchByBlockerId(usuarioAuth.getBlocker().getId(), inicio, total);

		for (Mensaje m : mensajes)
			Main.setNullFields(m);

		return mensajes;
	}

	@GetMapping("blocker/inbox/{mensajeId}")
	public Mensaje ver(@PathVariable(value = "mensajeId") Long mensajeId) {

		Mensaje mensaje = mensajeService.findOne(mensajeId);
		Main.setNullFields(mensaje);

		return mensaje;
	}

	@GetMapping("cliente/historial")
	public List<Contrato> historial(@RequestParam(name = "finalizado", defaultValue = "false") Boolean finalizado,
			@RequestParam(name = "inicio", defaultValue = "0") Integer inicio,
			@RequestParam(name = "total", defaultValue = "5") Integer total) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Usuario usuarioAuth = usuarioDao.findByEmail(email);

		List<Contrato> contratos = contratoService.fetchByClienteId(usuarioAuth.getCliente().getId(), finalizado,
				inicio, total);

		for (Contrato c : contratos)
			Main.setNullFields(c);

		return contratos;

	}

	@GetMapping("blocker/historial")
	public List<Contrato> historialBlocker(
			@RequestParam(name = "finalizado", defaultValue = "false") Boolean finalizado,
			@RequestParam(name = "inicio", defaultValue = "0") Integer inicio,
			@RequestParam(name = "total", defaultValue = "5") Integer total) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Usuario usuarioAuth = usuarioDao.findByEmail(email);

		List<Contrato> contratos = contratoService.fetchByBlockerId(usuarioAuth.getBlocker().getId(), finalizado,
				inicio, total);

		for (Contrato c : contratos)
			Main.setNullFields(c);

		return contratos;

	}

	@GetMapping("/contrato/{mensajeId}")
	public Contrato contratar(@PathVariable(value = "mensajeId") Long mensajeId) {

		Mensaje mensaje = mensajeService.findOne(mensajeId);

		Contrato contrato = new Contrato();

		contrato.setCostoFinal(mensaje.getCosto());
		contrato.setBlocker(mensaje.getBlocker());
		Main.setNullFields(contrato.getBlocker());
		contrato.setCliente(mensaje.getCliente());
		Main.setNullFields(contrato.getCliente());
		contrato.setServicio(mensaje.getServicio());
		Main.setNullFields(contrato.getServicio());

		contrato.setTiempoEstimado(mensaje.getTiempoEstimado());

		return contrato;
	}

	@PostMapping("/contrato")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> contratar(
			@RequestParam(value = "estadoCliente", required = false, defaultValue = "null") Boolean estadoCliente,
			@RequestParam(value = "estadoBlocker", required = false, defaultValue = "null") Boolean estadoBlocker,
			@RequestParam(value = "confirmarCancelacion", required = false, defaultValue = "null") Boolean confirmarCancelacion,
			@RequestParam(value = "actualizar", required = false, defaultValue = "null") Boolean actualizar,
			@RequestBody @Valid Contrato contrato) {
		
		if (contrato.getHaFinalizado() == true)
			return new ResponseEntity<>("El contrato ha finalizado", HttpStatus.GONE);
		
		Blocker blocker = contrato.getBlocker();
		Cliente cliente = contrato.getCliente();

		if (contrato.getId() == null)
			blocker.setTrabajosEnProceso(blocker.getTrabajosEnProceso() + 1);

		if (estadoCliente != null || estadoBlocker != null) {

			if (estadoCliente != null) {
				
				if (actualizar) {
					
					Integer calificacionAnterior = contratoService.findOne(contrato.getId()).getCalificacionBlocker();
					
					if (contrato.getCalificacionBlocker() != calificacionAnterior) {
						
						Float reputacionAnterior = (blocker.getReputacion() * blocker.getNumeroCalificaciones()
								- calificacionAnterior) / (blocker.getNumeroCalificaciones() - 1);
						
						blocker.setReputacion((contrato.getCalificacionBlocker() + reputacionAnterior
								* (blocker.getNumeroCalificaciones() - 1) / blocker.getNumeroCalificaciones()));
					}
					
					if (estadoCliente != contrato.getConfirmacionCliente()) {
						contrato.setConfirmacionCliente(estadoCliente);
						blocker.setNumeroTrabajosCulminados(blocker.getNumeroTrabajosCulminados() + 1);
						cliente.setNumeroServiciosContratados(cliente.getNumeroServiciosContratados() + 1);
					}
				
				} else {
					contrato.setFechaFinal(new Date(System.currentTimeMillis() + 60*60*24*1000*5L));
					blocker.setNumeroCalificaciones(blocker.getNumeroCalificaciones() + 1);

					if (blocker.getReputacion() != null)
						blocker.setReputacion((contrato.getCalificacionBlocker() + blocker.getReputacion()
								* (blocker.getNumeroCalificaciones() - 1)) / blocker.getNumeroCalificaciones());
					else
						blocker.setReputacion(contrato.getCalificacionBlocker().floatValue());

					if (estadoCliente) {
						blocker.setNumeroTrabajosCulminados(blocker.getNumeroTrabajosCulminados() + 1);
						cliente.setNumeroServiciosContratados(cliente.getNumeroServiciosContratados() + 1);
					}
				}
				
			}

			if (estadoBlocker != null) {
				
				if (actualizar) {
					
					Integer calificacionAnterior = contratoService.findOne(contrato.getId()).getCalificacionCliente();
					
					if (contrato.getCalificacionCliente() != calificacionAnterior) {
						Float reputacionAnterior = (cliente.getReputacion() * cliente.getNumeroCalificaciones()
								- calificacionAnterior) / (cliente.getNumeroCalificaciones() - 1);
						
						cliente.setReputacion((contrato.getCalificacionCliente() + reputacionAnterior
								* (cliente.getNumeroCalificaciones() - 1) / cliente.getNumeroCalificaciones()));
					}
				}
				
				else {
					contrato.setCulminacionBlocker(estadoBlocker);
					contrato.setFechaFinal(new Date(System.currentTimeMillis() + 60*60*24*1000*5L));
					cliente.setNumeroCalificaciones(cliente.getNumeroCalificaciones() + 1);
					blocker.setTrabajosEnProceso(blocker.getTrabajosEnProceso() - 1);

					if (cliente.getReputacion() != null)
						cliente.setReputacion((contrato.getCalificacionCliente() * (cliente.getNumeroCalificaciones() - 1)
								+ cliente.getReputacion()) / cliente.getNumeroCalificaciones());
					else
						cliente.setReputacion(contrato.getCalificacionCliente().floatValue());
				}
			}
		}

		if (contrato.getConfirmacionCliente() != null && contrato.getCulminacionBlocker() != null)
			contrato.setHaFinalizado(true);
		
		if (confirmarCancelacion != null) {
			if (confirmarCancelacion) {
				contrato.setObservacionesCliente("Cancelado");
				contrato.setHaFinalizado(true);
			} else {
				// Send push notification
				//dueScheduler.scheduleDue(1000*60*60*24*3L, contrato.getId());
				contrato.setObservacionesBlocker("Cancelado");
				contrato.setFechaFinal(new Date(System.currentTimeMillis() + 60*60*24*1000*5L));
			}
		}

		blockerService.save(blocker);
		clienteService.save(cliente);
		contratoService.save(contrato);
		
		return new ResponseEntity<>("El contrato ha sido actualizado con éxito", HttpStatus.OK);
		
		}
	}

