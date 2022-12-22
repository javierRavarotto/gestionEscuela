package com.gestionEscuela.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.repositorios.MateriasRepositorio;

import errorServicio.ErrorServicio;

@Service
public class MateriasServicios {
	
	@Autowired
	private MateriasRepositorio materiasRepositorio;

	@Transactional
	public void crearMateria(String nombre) throws ErrorServicio {
		try {
			

			Materias materia = new Materias();
			materia.setNombreMateria(nombre);
			materia.setAlta(true);
			materia.setFechaCreacion(new Date());
			materia.setFechaEdit(null);
			materia.setFormato(nombre);
			materia.setRegularidad(nombre);
			materia.setCantidadHoras(0);
			materia.setModalidadCursado(nombre);
			
			materiasRepositorio.save(materia);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

}
