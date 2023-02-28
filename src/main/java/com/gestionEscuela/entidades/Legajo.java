package com.gestionEscuela.entidades;

import java.util.Date;

//----------------------------------------
	// ANOTACIONES

//Falta el ONE to ONE con el Alumnos

	// Cierro ANOTACIONES
//----------------------------------------


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Legajo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLegajo;
	private Boolean partidaNacimiento;
	private Boolean fotocopiaDNI;
	private Boolean tituloSecundario;
	private String descripcionTitulo;
	private Boolean cooperadora;
	private String descripcionCooperadora;
	private String anotaciones;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	 @OneToMany(mappedBy = "idVacuna")
	 private List<Vacunas> vacunas;
	
	public Integer getIdLegajo() {
		return idLegajo;
	}
	public void setIdLegajo(Integer idLegajo) {
		this.idLegajo = idLegajo;
	}
	public Boolean getPatidaNacimiento() {
	return partidaNacimiento;
	}
	public void setPatidaNacimiento(Boolean partidaNacimiento) {
	this.partidaNacimiento = partidaNacimiento;
	}
	public Boolean getFotocopiaDNI() {
	return fotocopiaDNI;
	}
	public void setFotocopiaDNI(Boolean fotocopiaDNI) {
	this.fotocopiaDNI = fotocopiaDNI;
	}
	public Boolean getTituloSecundario() {
	return tituloSecundario;
	}
	public void setTituloSecundario(Boolean tituloSecundario) {
	this.tituloSecundario = tituloSecundario;
	}
	public String getDescripcionTitulo() {
	return descripcionTitulo;
	}
	public void setDescripcionTitulo(String descripcionTitulo) {
	this.descripcionTitulo = descripcionTitulo;
	}
	public Boolean getCooperadora() {
	return cooperadora;
	}
	public void setCooperadora(Boolean cooperadora) {
	this.cooperadora = cooperadora;
	}
	public String getDescripcionCooperadora() {
	return descripcionCooperadora;
	}
	public void setDescripcionCooperadora(String descripcionCooperadora) {
	this.descripcionCooperadora = descripcionCooperadora;
	}
	public String getAnotaciones() {
	return anotaciones;
	}
	public void setAnotaciones(String anotaciones) {
	this.anotaciones = anotaciones;
	}
	

	public Boolean getPartidaNacimiento() {
		return partidaNacimiento;
	}
	public void setPartidaNacimiento(Boolean partidaNacimiento) {
		this.partidaNacimiento = partidaNacimiento;
	}
	public List<Vacunas> getVacunas() {
		return vacunas;
	}
	public void setVacunas(List<Vacunas> vacunas) {
		this.vacunas = vacunas;
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
	public Legajo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Legajo(Integer idLegajo, Boolean partidaNacimiento, Boolean fotocopiaDNI, Boolean tituloSecundario,
			String descripcionTitulo, Boolean cooperadora, String descripcionCooperadora, String anotaciones,
			Boolean alta, Date fechaCreacion, Date fechaEdit, List<Vacunas> vacunas) {
		super();
		this.idLegajo = idLegajo;
		this.partidaNacimiento = partidaNacimiento;
		this.fotocopiaDNI = fotocopiaDNI;
		this.tituloSecundario = tituloSecundario;
		this.descripcionTitulo = descripcionTitulo;
		this.cooperadora = cooperadora;
		this.descripcionCooperadora = descripcionCooperadora;
		this.anotaciones = anotaciones;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.vacunas = vacunas;
	}
	
}