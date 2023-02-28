package com.gestionEscuela.entidades;


<<<<<<< HEAD
import java.util.Date;

=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.ManyToOne;
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb

@Entity
public class Articulos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticulo;
	private String nombre;
	private String descripcion;
<<<<<<< HEAD
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	@ManyToOne
	private ArticulosTomados articulosTomados;
=======
	
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
<<<<<<< HEAD
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
	

	public ArticulosTomados getArticulosTomados() {
		return articulosTomados;
	}
	public void setArticulosTomados(ArticulosTomados articulosTomados) {
		this.articulosTomados = articulosTomados;
	}


	public Date getFechaEdit() {
		return fechaEdit;
	}
	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}
	
	public Articulos(Integer idArticulo, String nombre, String descripcion, Boolean alta, Date fechaCreacion,
			Date fechaEdit, ArticulosTomados articulosTomados) {
=======
	
	public Articulos(Integer idArticulo, String nombre, String descripcion) {
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
		super();
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
<<<<<<< HEAD
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.articulosTomados = articulosTomados;
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
	}
	public Articulos() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	
	
	

=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
}
