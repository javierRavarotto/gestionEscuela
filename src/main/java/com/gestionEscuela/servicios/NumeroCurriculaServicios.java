package com.gestionEscuela.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.entidades.NumeroCurricula;
import com.gestionEscuela.repositorios.MateriasRepositorio;
import com.gestionEscuela.repositorios.NumeroCurriculaRepositorio;

import errorServicio.ErrorServicio;

@Service
public class NumeroCurriculaServicios {

	
	@Autowired
	NumeroCurriculaRepositorio numeroCurriculaRepositorio;
	
	@Autowired
	MateriasRepositorio materiasRepositorio;
	
	@Autowired
	MateriasServicios materiasServicios;
	
	public NumeroCurricula buscarUltima() {
		NumeroCurricula numeroCurricula = numeroCurriculaRepositorio.buscarUltima();
		return numeroCurricula;
	}
	
	public NumeroCurricula buscarId(Integer id) {
		NumeroCurricula numeroCurricula = numeroCurriculaRepositorio.findById(id).get();
		return numeroCurricula;
	}
	
	@Transactional
	public void crearNumeroCurricula(String nombre) throws ErrorServicio {
		try {
			NumeroCurricula articulo = new NumeroCurricula();
			articulo.setNombre(nombre);
			
			articulo.setAlta(true);
			articulo.setFechaCreacion(new Date()); 
			numeroCurriculaRepositorio.save(articulo);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
	
	@Transactional
	public void agregarMateriaCurricula(Integer idCurricula , Integer idMateria) throws ErrorServicio {
		try {
			NumeroCurricula curricula = buscarId(idCurricula);
			Materias materia = materiasServicios.buscarId(idMateria);
			curricula.getMaterias().add(materia);
			
			 numeroCurriculaRepositorio.save(curricula);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
	@Transactional
	public void eliminarMateriaCurricula(Integer idCurricula , Integer idMateria) throws ErrorServicio {
		try {
			NumeroCurricula curricula = buscarId(idCurricula);
			Materias materia = materiasServicios.buscarId(idMateria);
			curricula.getMaterias().remove(materia);
			 numeroCurriculaRepositorio.save(curricula);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
}
