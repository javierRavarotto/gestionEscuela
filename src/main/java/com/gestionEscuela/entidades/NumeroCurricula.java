package com.gestionEscuela.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NumeroCurricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurricula;
	private String nombre;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	
	 @OneToMany(mappedBy = "idMateria")
	 private List<Materias> materias;
	

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
	
	

}