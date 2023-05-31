package com.gestionEscuela.entidades;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




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
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	@OneToOne
	private Legajo legajo;
	@OneToMany	
	private Set<Materias> materiasRegular;
	@OneToMany
	private Set<Materias> materiasIrregular;
	
	public Alumnos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumnos(Integer idAlumno, String nombre, String apellido, Integer dni, Integer telefono, String domicilio,
			String email, String observaciones, Boolean alta, Date fechaCreacion, Date fechaEdit, Legajo legajo,
			Set<Materias> materiasRegular, Set<Materias> materiasIregular) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.observaciones = observaciones;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.legajo = legajo;
		this.materiasRegular = materiasRegular;
		this.materiasIrregular = materiasIregular;
	}

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

	public Legajo getLegajo() {
		return legajo;
	}

	public void setLegajo(Legajo legajo) {
		this.legajo = legajo;
	}

	public Set<Materias> getMateriasRegular() {
		return materiasRegular;
	}

	public void setMateriasRegular(Set<Materias> materiasRegular) {
		this.materiasRegular = materiasRegular;
	}

	public Set<Materias> getMateriasIregular() {
		return materiasIrregular;
	}

	public void setMateriasIregular(Set<Materias> materiasIregular) {
		this.materiasIrregular = materiasIregular;
	}

	@Override
	public String toString() {
		return "Alumnos [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", telefono=" + telefono + ", domicilio=" + domicilio + ", email=" + email + ", observaciones="
				+ observaciones + ", alta=" + alta + ", fechaCreacion=" + fechaCreacion + ", fechaEdit=" + fechaEdit
				+ ", legajo=" + legajo + ", materiasRegular=" + materiasRegular + ", materiasIregular="
				+ materiasIrregular + "]";
	}

	
}