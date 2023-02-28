package com.gestionEscuela.entidades;

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
import java.util.Date;
import java.util.List;
import java.util.Set;
=======
import java.util.List;
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.ManyToMany;
=======
import javax.persistence.OneToMany;
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb

@Entity
public class NumeroCurricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurricula;
	private String nombre;
<<<<<<< HEAD
<<<<<<< HEAD
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	@ManyToMany	
	private Set<Materias> materia;
	public NumeroCurricula() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NumeroCurricula(Integer idCurricula, String nombre, Boolean alta, Date fechaCreacion, Date fechaEdit,
			Set<Materias>  materias) {
		super();
		this.idCurricula = idCurricula;
		this.nombre = nombre;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.materia = materias;
	}
=======
=======
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
	
	 @OneToMany(mappedBy = "idMateria")
	 private List<Materias> materias;
	

>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
	public Integer getIdCurricula() {
		return idCurricula;
	}
	public void setIdCurricula(Integer idCurricula) {
		this.idCurricula = idCurricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======
	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
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
<<<<<<< HEAD
	public Set<Materias>  getMaterias() {
		return materia;
	}
	public void setMaterias(Set<Materias>  materias) {
		this.materia = materias;
	}
	@Override
	public String toString() {
		return "NumeroCurricula [idCurricula=" + idCurricula + ", nombre=" + nombre + ", alta=" + alta
				+ ", fechaCreacion=" + fechaCreacion + ", fechaEdit=" + fechaEdit + ", materias=" + materia + "]";
	}
	
	
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
	public NumeroCurricula(Integer idCurricula, String nombre, Boolean alta, Date fechaCreacion, Date fechaEdit,
			List<Materias> materias) {
		super();
		this.idCurricula = idCurricula;
		this.nombre = nombre;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.materias = materias;
	}
	
	
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33

}