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
	private VacunasRepositorio vacunasRepositorio;
	
	@Transactional
	public void crearVacuna(String nombre) throws ErrorServicio {
		try {
			System.out.println(nombre);
			Vacunas vacuna = new Vacunas();
			vacuna.setNombre(nombre);
			vacuna.setAlta(true);
			vacuna.setFechaCreacion(new Date());
			vacunasRepositorio.save(vacuna);
		} catch (Exception e) {
			System.out.println(nombre);
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

	@Transactional
	public void editarVacuna(String nombre,Integer id) throws ErrorServicio {
		try {
			Vacunas vacuna = buscarPorId(id);
			vacuna.setNombre(nombre);
			vacunasRepositorio.save(vacuna);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void deleteVacuna(Integer id) throws ErrorServicio {
		System.out.println(id);
		try {
			Vacunas vacuna = buscarPorId(id);
			
			vacunasRepositorio.delete(vacuna);
			
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void altaBaja(Integer id)throws ErrorServicio {
		Vacunas vacuna = vacunasRepositorio.findById(id).get();
		if(vacuna.getAlta()==true) {
			vacuna.setAlta(false);
		}else {
			vacuna.setAlta(true);
		}
		vacunasRepositorio.save(vacuna);	
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
public Vacunas buscarPorId(Integer id) {
		Vacunas vacuna = vacunasRepositorio.findById(id).get();
		return vacuna;
	}
}
