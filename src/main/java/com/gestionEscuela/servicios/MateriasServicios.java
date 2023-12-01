package com.gestionEscuela.servicios;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ServerErrorException;

import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.repositorios.MateriasRepositorio;

import errorServicio.ErrorServicio;

@Service
public class MateriasServicios {
	
	@Autowired
	private MateriasRepositorio materiasRepositorio;


	public Materias buscarId(Integer id) {
		Materias materia = materiasRepositorio.findById(id).get();
		return materia;
	}
	
	@Transactional
	public Materias crearMateria(String nombre , String formato, Integer cantidadHoras, String modalidadCursaro) throws ErrorServicio {
		try {
			Materias materia = new Materias();
			materia.setNombreMateria(nombre);
			materia.setAlta(true);
			materia.setFechaCreacion(new Date());
			materia.setFechaEdit(null);
			materia.setFormato(formato);
			materia.setRegularidad(null);
			materia.setCantidadHoras(cantidadHoras);
			materia.setModalidadCursado(modalidadCursaro);
			return materiasRepositorio.save(materia);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
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
	public void altaBaja(Integer id)throws ErrorServicio {
		Materias materias = buscarId(id);
		if(materias.getAlta()==true) {
			materias.setAlta(false);
		}else {
			materias.setAlta(true);
		}
		materiasRepositorio.save(materias);	
	}
	@Transactional
	public void editarMateria(Integer id ,String nombre,String formato, Integer cantidadHoras,String modalidadCursaro) throws ErrorServicio {
		try {
			Materias materia = buscarId(id);
			materia.setNombreMateria(nombre);
			materia.setFormato(formato);
			materia.setCantidadHoras(cantidadHoras);
			materia.setModalidadCursado(modalidadCursaro);
			materia.setFormato(nombre);
			materia.setRegularidad(nombre);
			materia.setCantidadHoras(0);
			materia.setModalidadCursado(nombre);
			materiasRepositorio.save(materia);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void deleteMateria(Integer id) throws DataIntegrityViolationException,ErrorServicio,ConstraintViolationException{
		try {
			Materias materia = buscarId(id);
			materiasRepositorio.delete(materia);	
		} catch (DataIntegrityViolationException e) {
 
		}
	}
}
