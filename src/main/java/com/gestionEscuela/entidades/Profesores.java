package com.gestionEscuela.entidades;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Profesores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String nombre;
	private String apellido;
	private Integer dni;
	private String domicilio;
	private Integer telefono;
	private String email;
	private Date tomaposesion;
	private Integer horascatedrastotales;
	private String observaciones;
    @OneToMany(mappedBy = "idMateria")
    private List<Materias> materias;
	private Boolean alta;

	private Date fechaCreacion;
	private Date fechaEdit;
	@ManyToMany	
	private Set<Articulos> articulos;
	public Profesores() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Profesores [idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", domicilio=" + domicilio + ", telefono=" + telefono + ", email=" + email + ", tomaposesion="
				+ tomaposesion + ", horascatedrastotales=" + horascatedrastotales + ", observaciones=" + observaciones
				+ ", materias=" + materias + ", alta=" + alta + ", fechaCreacion=" + fechaCreacion + ", fechaEdit="
				+ fechaEdit + ", articulos=" + articulos + "]";
	}

	public Set<Articulos> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Articulos> articulos) {
		this.articulos = articulos;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
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
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTomaposesion() {
		return tomaposesion;
	}
	public void setTomaposesion(Date tomaposesion) {
		this.tomaposesion = tomaposesion;
	}
	public Integer getHorascatedrastotales() {
		return horascatedrastotales;
	}
	public void setHorascatedrastotales(Integer horascatedrastotales) {
		this.horascatedrastotales = horascatedrastotales;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
	public Boolean getAlta() {
		return alta;
	}
	public void setAlta(Boolean alta) {
		this.alta = alta;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaEdit() {
		return fechaEdit;
	}
	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}
  
	
	
	
}
