package com.gestionEscuela.entidades;
import java.util.Date;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToOne;


@Entity
public class Articulos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArticulo;
	private String nombre;
	private String descripcion;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	private Integer cantidad;
	public Articulos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articulos(Integer idArticulo, String nombre, String descripcion, Boolean alta, Date fechaCreacion,
			Date fechaEdit, Integer cantidad) {
		super();
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.cantidad = cantidad;
		
	}
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Articulos [idArticulo=" + idArticulo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", alta="
				+ alta + ", fechaCreacion=" + fechaCreacion + ", fechaEdit=" + fechaEdit + ", cantidad=" + cantidad
				+ ", articulosTomados=" + "]";
	}

	

}
