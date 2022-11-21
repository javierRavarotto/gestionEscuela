package com.gestionEscuela.entidades;

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
	
	 @OneToMany
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
	
	public Legajo(Integer idLegajo, Boolean partidaNacimiento, Boolean fotocopiaDNI, Boolean tituloSecundario, String descripcionTitulo
			,Boolean cooperadora, String descripcionCooperadora, String anotaciones) {
		super();
		this.idLegajo = idLegajo;
		this.partidaNacimiento = partidaNacimiento;
		this.fotocopiaDNI = fotocopiaDNI;
		this.tituloSecundario = tituloSecundario;
		this.descripcionTitulo = descripcionTitulo;
		this.cooperadora = cooperadora;
		this.descripcionCooperadora = descripcionCooperadora;
	}
	public Legajo() {
		super();
		// TODO Auto-generated constructor stub
	}
}