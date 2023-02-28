package com.gestionEscuela.servicios;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.entidades.NumeroCurricula;
import com.gestionEscuela.entidades.Vacunas;
import com.gestionEscuela.repositorios.MateriasRepositorio;

import errorServicio.ErrorServicio;

=======
=======
import java.util.Date;

>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.repositorios.MateriasRepositorio;

<<<<<<< HEAD
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======
import errorServicio.ErrorServicio;

>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
@Service
public class MateriasServicios {
	
	@Autowired
	private MateriasRepositorio materiasRepositorio;

<<<<<<< HEAD
<<<<<<< HEAD
	public Materias buscarId(Integer id) {
		Materias materia = materiasRepositorio.findById(id).get();
		return materia;
	}
	
	@Transactional
	public Materias crearMateria(String nombre , String formato, Integer cantidadHoras, String modalidadCursaro) throws ErrorServicio {
		try {
			Materias materia = new Materias();
			materia.setIdMateria(0);
=======
	@Transactional
	public void crearMateria(String nombre) throws ErrorServicio {
		try {
			

			Materias materia = new Materias();
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
			materia.setNombreMateria(nombre);
			materia.setAlta(true);
			materia.setFechaCreacion(new Date());
			materia.setFechaEdit(null);
<<<<<<< HEAD
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
=======
			materia.setFormato(nombre);
			materia.setRegularidad(nombre);
			materia.setCantidadHoras(0);
			materia.setModalidadCursado(nombre);
			
>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
			materiasRepositorio.save(materia);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
<<<<<<< HEAD
//borrar materia
	@Transactional
	public void deleteMateria(Integer id) throws ErrorServicio {
		
		try {
			Materias materia = buscarId(id);
			
			
			materiasRepositorio.delete(materia);
			
		} catch (Exception e) {
			 System.out.println(id + "system");
			 System.out.println(id + "estea esta entrandoa ca vos que decsestea esta entrandoa ca vos que decsestea esta entrandoa ca vos que decsestea esta entrandoa ca vos que decsestea esta entrandoa ca vos que decsestea esta entrandoa ca vos que decsestea esta entrandoa ca vos que decs");
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
=======
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
=======

>>>>>>> 4fcfd6bd64c6c87c15d5a4556249cff37af3ee33
}
