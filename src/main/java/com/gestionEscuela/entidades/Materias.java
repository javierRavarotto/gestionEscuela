package com.gestionEscuela.entidades;

import java.util.Date;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.persistence.ManyToMany;

@Entity
public class Materias{
=======

@Entity
public class Materias {
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
import javax.persistence.ManyToOne;

@Entity
public class Materias{
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
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
<<<<<<< HEAD
<<<<<<< HEAD
	private Date fechaEdit;
	@ManyToMany(mappedBy = "materia")	
	private Set<NumeroCurricula> curriculas;
	
=======
	private Date fechaBaja;
	
 
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
	private Date fechaEdit;
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
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

<<<<<<< HEAD
<<<<<<< HEAD
	public Materias(Integer idMateria, String formato, String nombreMateria, int cantidadHoras, String regularidad,
			String modalidadCursado, Boolean alta, Date fechaCreacion, Date fechaEdit,
			Set<NumeroCurricula> curriculas) {
=======
	public Materias(int idMateria, String formato, String nombreMateria, int cantidadHoras, String regularidad,
			String modalidadCursado, Boolean alta, Date fechaCreacion, Date fechaBaja) {
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}
	public Materias(Integer idMateria, String formato, String nombreMateria, int cantidadHoras, String regularidad,
			String modalidadCursado, Boolean alta, Date fechaCreacion, Date fechaEdit) {
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
		super();
		this.idMateria = idMateria;
		this.formato = formato;
		this.nombreMateria = nombreMateria;
		this.cantidadHoras = cantidadHoras;
		this.regularidad = regularidad;
		this.modalidadCursado = modalidadCursado;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
<<<<<<< HEAD
<<<<<<< HEAD
		this.fechaEdit = fechaEdit;
		this.curriculas = curriculas;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
=======
		this.fechaBaja = fechaBaja;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
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

<<<<<<< HEAD
	public Date getFechaEdit() {
		return fechaEdit;
	}

	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}

	public Set<NumeroCurricula> getCurriculas() {
		return curriculas;
	}

	public void setCurriculas(Set<NumeroCurricula> curriculas) {
		this.curriculas = curriculas;
	}

	
	
=======
	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
	
=======
		this.fechaEdit = fechaEdit;
	}
	@Override
	public String toString() {
		return "Materias [idMateria=" + idMateria + ", formato=" + formato + ", nombreMateria=" + nombreMateria
				+ ", cantidadHoras=" + cantidadHoras + ", regularidad=" + regularidad + ", modalidadCursado="
				+ modalidadCursado + ", alta=" + alta + ", fechaCreacion=" + fechaCreacion + ", fechaEdit=" + fechaEdit
				+ "]";
	}

>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
}


