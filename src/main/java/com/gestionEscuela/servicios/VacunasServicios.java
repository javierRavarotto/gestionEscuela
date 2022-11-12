package com.gestionEscuela.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Vacunas;
import com.gestionEscuela.repositorios.VacunasRepositorio;

import errorServicio.ErrorServicio;

@Service
public class VacunasServicios {
	
	@Autowired
	private VacunasRepositorio vacunasRepositori;
	
	@Transactional
	public void crearVacuna(String nombre) throws ErrorServicio {
		try {
			Vacunas vacuna = new Vacunas();
			vacuna.setNombre(nombre);
			vacuna.setAlta(true);
			vacuna.setFechaCreacion(new Date());
			vacunasRepositori.save(vacuna);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}	
}
