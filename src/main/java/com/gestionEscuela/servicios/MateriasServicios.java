package com.gestionEscuela.servicios;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionEscuela.repositorios.MateriasRepositorio;

>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb
@Service
public class MateriasServicios {
	
	@Autowired
	private MateriasRepositorio materiasRepositorio;

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
			materiasRepositorio.save(materia);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
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
}
