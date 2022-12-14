package com.gestionEscuela.entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



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
	
	
    @OneToMany
    private List<Materias> materias;
	
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
	public void setDate(Date tomaposesion) {
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
	public Profesores(Integer idProfesor, String nombre, String apellido, Integer dni, String domicilio, Integer telefono, 
			String email, Date tomaposesion, Integer horascatedrastotales, String observaciones) {
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.tomaposesion = tomaposesion;
		this.horascatedrastotales = horascatedrastotales;
		this.observaciones = observaciones;
		
	}
	
	public Profesores() {
		super();
		// TODO Auto-generated constructor stub
	}
}
