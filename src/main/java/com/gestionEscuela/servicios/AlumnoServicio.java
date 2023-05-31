package com.gestionEscuela.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Alumnos;
import com.gestionEscuela.entidades.Legajo;
import com.gestionEscuela.repositorios.AlumnoRepositorio;

import errorServicio.ErrorServicio;

@Service
public class AlumnoServicio {

	
	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	@Autowired
	MateriasServicios materiaServicio;
	
	@Autowired
	LegajoServicios legajoServicio;
	
	
	public Alumnos buscarId(Integer id) {
		Alumnos alumno = alumnoRepositorio.findById(id).get();
		return alumno;
	}
	
	@Transactional
	public void crearAlumno( String nombre ,String apellido, Integer dni,  Integer telefono,
			String domicilio,  String email,String observaciones) throws ErrorServicio {
		try {
			Alumnos alumno = new Alumnos();
			alumno.setNombre(nombre);
			alumno.setApellido(apellido);
			alumno.setDni(dni);
			alumno.setTelefono(telefono);
			alumno.setDomicilio(domicilio);
			alumno.setEmail(email);
			alumno.setObservaciones(observaciones);
			alumno.setAlta(true);
			alumno.setFechaCreacion(new Date()); 
			alumnoRepositorio.save(alumno);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void editarAlumno(Integer id,String nombre ,String apellido, Integer dni,  Integer telefono,
			String domicilio,  String email,String observaciones) throws ErrorServicio {
		try {
			Alumnos alumno = buscarId(id);
			alumno.setNombre(nombre);
			alumno.setApellido(apellido);
			alumno.setDni(dni);
			alumno.setTelefono(telefono);
			alumno.setDomicilio(domicilio);
			alumno.setEmail(email);
			alumno.setObservaciones(observaciones);
			alumno.setFechaEdit(new Date());
			alumnoRepositorio.save(alumno);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
	@Transactional
	public void altaBaja(Integer id)throws ErrorServicio {
		Alumnos alumno = alumnoRepositorio.findById(id).get();

		if(alumno.getAlta()==true) {
			alumno.setAlta(false);
		}else {
			alumno.setAlta(true);
		}
		alumnoRepositorio.save(alumno);	
	}
	public Boolean  mostrarAlta(Boolean altas)throws ErrorServicio {
		if(altas==false) {
			altas=true;
		}
		return altas;
	}
	public Boolean  mostrarBaja(Boolean altas)throws ErrorServicio {
		if(altas==true) {
			altas=false;
		}
		return altas;
		}
	@Transactional
	public void deleteAlumno(Integer id) throws ErrorServicio {
		try {
			Alumnos alumno = buscarId(id);
			alumnoRepositorio.delete(alumno);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
	@Transactional
	public void agregarLegajoAlumno(Integer id,Integer idLegajo)throws ErrorServicio {
		Alumnos alumno = buscarId(id);
		Legajo legajo = legajoServicio.buscarUltima();
		System.out.print(legajo);
		alumno.setLegajo(legajo);
		
		alumnoRepositorio.save(alumno);	
	}
}
