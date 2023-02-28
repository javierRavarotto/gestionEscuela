package com.gestionEscuela.entidades;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
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
<<<<<<< HEAD
import javax.persistence.OneToMany;
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb


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
<<<<<<< HEAD
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	@OneToMany(mappedBy = "idMateria")
	private List<Materias> materias;
	
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
	
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
<<<<<<< HEAD
	
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
	public Alumnos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alumnos(Integer idAlumno, String nombre, String apellido, Integer dni, Integer telefono, String domicilio,
			String email, String observaciones, Boolean alta, Date fechaCreacion, Date fechaEdit,
			List<Materias> materias) {
=======
	public Alumnos(Integer idAlumno, String nombre, String apellido, Integer dni, String domicilio, Integer telefono, 
			String email, String observaciones) {
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
<<<<<<< HEAD
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.observaciones = observaciones;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.materias = materias;
	}
	
=======
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.observaciones = observaciones;
	}
	public Alumnos() {
		super();
		// TODO Auto-generated constructor stub
	}
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
}