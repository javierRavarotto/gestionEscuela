package com.gestionEscuela.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Materias{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  idMateria;
	private String formato;
	private String nombreMateria;
	private int cantidadHoras;
	private String regularidad;
	private String modalidadCursado;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	public Materias() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public int getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	public String getRegularidad() {
		return regularidad;
	}
	public void setRegularidad(String regularidad) {
		this.regularidad = regularidad;
	}
	public String getModalidadCursado() {
		return modalidadCursado;
	}
	public void setModalidadCursado(String modalidadCursado) {
		this.modalidadCursado = modalidadCursado;
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
	public Materias(Integer idMateria, String formato, String nombreMateria, int cantidadHoras, String regularidad,
			String modalidadCursado, Boolean alta, Date fechaCreacion, Date fechaEdit) {
		super();
		this.idMateria = idMateria;
		this.formato = formato;
		this.nombreMateria = nombreMateria;
		this.cantidadHoras = cantidadHoras;
		this.regularidad = regularidad;
		this.modalidadCursado = modalidadCursado;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
	}
	@Override
	public String toString() {
		return "Materias [idMateria=" + idMateria + ", formato=" + formato + ", nombreMateria=" + nombreMateria
				+ ", cantidadHoras=" + cantidadHoras + ", regularidad=" + regularidad + ", modalidadCursado="
				+ modalidadCursado + ", alta=" + alta + ", fechaCreacion=" + fechaCreacion + ", fechaEdit=" + fechaEdit
				+ "]";
	}

}


