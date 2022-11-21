package com.gestionEscuela.entidades;

//-----------------------------------------------------------------------------------------
	// ANOTACIONES

// Falta el ONE to ONE con el Legajo
// Falta el Cursado<Listamaterias> No se si era un ONE to ONE o una clase aparte

	// Cierro ANOTACIONES
//-----------------------------------------------------------------------------------------

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Alumnos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer telefono;
	private String domicilio;
	private String email;
	private String observaciones;
	
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
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
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Alumnos(Integer idAlumno, String nombre, String apellido, Integer dni, String domicilio, Integer telefono, 
			String email, String observaciones) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.observaciones = observaciones;
	}
	public Alumnos() {
		super();
		// TODO Auto-generated constructor stub
	}
}