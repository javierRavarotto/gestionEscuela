package com.gestionEscuela.entidades;

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
	
	 @OneToMany
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

}