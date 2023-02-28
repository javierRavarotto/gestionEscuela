package com.gestionEscuela.entidades;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
=======
import java.util.List;

>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

<<<<<<< HEAD

//cuando se moto el articulo

=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
@Entity
public class ArticulosTomados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticuloTomado;
<<<<<<< HEAD
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
=======
	
	 @OneToMany
	 private List<Articulos> articulo;
	

>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
	public Integer getIdArticuloTomado() {
		return idArticuloTomado;
	}
	public void setIdArticuloTomado(Integer idArticuloTomado) {
		this.idArticuloTomado = idArticuloTomado;
	}
<<<<<<< HEAD
	public List<Articulos> getArticulo() {
		return articulo;
	}
	public void setArticulo(List<Articulos> articulo) {
		this.articulo = articulo;
	}
	
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb

}