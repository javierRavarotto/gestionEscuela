package com.gestionEscuela.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vacunas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  idVacuna;
	private String nombre;
	private Boolean alta;
	private Date fechaCreacion;
<<<<<<< HEAD
<<<<<<< HEAD
	private Date fechaEdit;
=======
	private Date fechaBaja;
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
	private Date fechaEdit;
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
	public Integer getIdVacuna() {
		return idVacuna;
	}
	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
	
	
	
	public Date getFechaEdit() {
		return fechaEdit;
<<<<<<< HEAD
	}
	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}
	public Vacunas(Integer idVacuna, String nombre, Boolean alta, Date fechaCreacion, Date fechaEdit) {
=======
	public Date getFechaBaja() {
		return fechaBaja;
=======
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
	}
	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}
<<<<<<< HEAD
	public Vacunas(Integer idVacuna, String nombre, Boolean alta, Date fechaCreacion, Date fechaBaja) {
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
	public Vacunas(Integer idVacuna, String nombre, Boolean alta, Date fechaCreacion, Date fechaEdit) {
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
		super();
		this.idVacuna = idVacuna;
		this.nombre = nombre;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
<<<<<<< HEAD
<<<<<<< HEAD
		this.fechaEdit = fechaEdit;
=======
		this.fechaBaja = fechaBaja;
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
		this.fechaEdit = fechaEdit;
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
	}
	public Vacunas() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
