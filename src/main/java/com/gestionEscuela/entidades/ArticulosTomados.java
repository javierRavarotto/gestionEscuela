package com.gestionEscuela.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


//cuando se moto el articulo

@Entity
public class ArticulosTomados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticuloTomado;
	@OneToMany(mappedBy = "articulosTomados")
	private List<Articulos> articulo;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	
	
	
	public ArticulosTomados(Integer idArticuloTomado, List<Articulos> articulo, Boolean alta, Date fechaCreacion,
			Date fechaEdit) {
		super();
		this.idArticuloTomado = idArticuloTomado;
		this.articulo = articulo;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
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
	public Integer getIdArticuloTomado() {
		return idArticuloTomado;
	}
	public void setIdArticuloTomado(Integer idArticuloTomado) {
		this.idArticuloTomado = idArticuloTomado;
	}
	public List<Articulos> getArticulo() {
		return articulo;
	}
	public void setArticulo(List<Articulos> articulo) {
		this.articulo = articulo;
	}
	

}