package com.gestionEscuela.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ArticulosTomados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticuloTomado;
	
	 @OneToMany
	 private List<Articulos> articulo;
	

	public Integer getIdArticuloTomado() {
		return idArticuloTomado;
	}
	public void setIdArticuloTomado(Integer idArticuloTomado) {
		this.idArticuloTomado = idArticuloTomado;
	}

}