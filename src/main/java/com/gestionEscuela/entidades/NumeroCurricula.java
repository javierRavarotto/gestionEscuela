package com.gestionEscuela.entidades;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class NumeroCurricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurricula;
	private String nombre;
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
	public Set<Materias> getMateria() {
		return materia;
	}
	public void setMateria(Set<Materias> materia) {
		this.materia = materia;
	}
	@Override
	public String toString() {
		return "NumeroCurricula [idCurricula=" + idCurricula + ", nombre=" + nombre + ", alta=" + alta
				+ ", fechaCreacion=" + fechaCreacion + ", fechaEdit=" + fechaEdit + ", materia=" + materia + "]";
	}

	
	

}