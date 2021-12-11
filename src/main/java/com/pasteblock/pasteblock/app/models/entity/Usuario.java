package com.pasteblock.pasteblock.app.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 15)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private List<Rol> roles;
	
	@NotBlank
	private String celular;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	private Cliente cliente;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	private Blocker blocker;

	@Column(name = "tiempo_registrado")
	private String tiempoRegistrado;

	@Column(name = "fecha_de_registro")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;
	
	@Column(name = "esta_activo")
	private Boolean estaActivo;
	
	@PrePersist
	public void prePersist() {
		estaActivo = true;
		fechaRegistro = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTiempoRegistrado() {
		setTiempoRegistrado();
		return tiempoRegistrado;
	}

	public void setTiempoRegistrado() {
		LocalDate startDate = null;
		try {
			startDate = ((java.sql.Date) this.getFechaRegistro()).toLocalDate();
		} catch (Exception e) {
			startDate = LocalDate.now();
		}
		LocalDate now = LocalDate.now();
		
		Period period = Period.between(
			     startDate,
			     now);
		Integer mesesRegistrado = (Integer) period.getMonths();
		Integer anosRegistrado = (Integer) period.getYears();
		this.tiempoRegistrado = anosRegistrado + " año(s)" + " y " + mesesRegistrado + " mes(es)";
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Boolean getEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(Boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Blocker getBlocker() {
		return blocker;
	}

	public void setBlocker(Blocker blocker) {
		this.blocker = blocker;
	}

	private static final long serialVersionUID = 1L;

}
