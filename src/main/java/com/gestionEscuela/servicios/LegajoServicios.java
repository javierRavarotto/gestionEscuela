package com.gestionEscuela.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Legajo;
import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.entidades.NumeroCurricula;
import com.gestionEscuela.entidades.Vacunas;
import com.gestionEscuela.repositorios.LegajoRepositorio;

import errorServicio.ErrorServicio;

@Service
public class LegajoServicios {
	
	@Autowired
	LegajoRepositorio legajoRepositorio;
	
	@Autowired
	VacunasServicios vacunasServicios;
	
	
	
	public Legajo buscarId(Integer id) {
		Legajo legajo = legajoRepositorio.findById(id).get();
		return legajo;
	}
	
	public Legajo buscarUltima() {
		Legajo legajo = legajoRepositorio.buscarUltima();
		return legajo;
	}
	
	@Transactional
	public void crearLegajo(Integer idAlmuno, Boolean partidaNacimiento,Boolean fotocopiaDNI, Boolean tituloSecundario, Boolean cooperadora,
			String descripcionTitulo,String descripcionCooperadora,String anotaciones) throws ErrorServicio {
		try {
			Legajo legajo = new Legajo();
			
			if(partidaNacimiento==null) {
				legajo.setPartidaNacimiento(false);
			}else {
				legajo.setPartidaNacimiento(partidaNacimiento);
			}
			
			if(fotocopiaDNI==null) {
				legajo.setFotocopiaDNI(false);
			}else {
				legajo.setFotocopiaDNI(fotocopiaDNI);
			}
			
			if(tituloSecundario==null) {
				legajo.setTituloSecundario(false);
			}else {
				legajo.setTituloSecundario(tituloSecundario);
			}
			
			if(cooperadora==null) {
				legajo.setCooperadora(false);
			}else {
				legajo.setCooperadora(cooperadora);
			}
			legajo.setDescripcionTitulo(descripcionTitulo);
			legajo.setDescripcionCooperadora(descripcionCooperadora);
			legajo.setAnotaciones(anotaciones);
			legajo.setAlta(true);
			legajo.setFechaCreacion(new Date()); 
			legajoRepositorio.save(legajo);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
	@Transactional
	public void editarLegajo(Integer id,Boolean partidaNacimiento,Boolean fotocopiaDNI, Boolean tituloSecundario, Boolean cooperadora,
			String descripcionTitulo,String descripcionCooperadora,String anotaciones) throws ErrorServicio {
		try {
			Legajo legajo = buscarId(id);
			legajo.setPartidaNacimiento(partidaNacimiento);
			legajo.setFotocopiaDNI(fotocopiaDNI);
			legajo.setTituloSecundario(tituloSecundario);
			legajo.setCooperadora(cooperadora);
			legajo.setDescripcionTitulo(descripcionTitulo);
			legajo.setDescripcionCooperadora(descripcionCooperadora);
			legajo.setAnotaciones(anotaciones);
			legajo.setAlta(true);
			legajo.setFechaCreacion(new Date()); 
			legajoRepositorio.save(legajo);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void altaBaja(Integer id)throws ErrorServicio {
		Legajo legajo = buscarId(id);

		if(legajo.getAlta()==true) {
			legajo.setAlta(false);
		}else {
			legajo.setAlta(true);
		}
		legajoRepositorio.save(legajo);	
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
	public void deleteLegajo(Integer id) throws ErrorServicio {
		try {
			Legajo legajo = buscarId(id);
			legajoRepositorio.delete(legajo);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

	
	@Transactional
	public void agregarVacunaLegajo(Integer idLegajo , Integer idVacuna) throws ErrorServicio {
		try {
			Legajo legajo = buscarId(idLegajo);
			Vacunas vacuna = vacunasServicios.buscarPorId(idVacuna);
			legajo.getVacunas().add(vacuna);
			 legajoRepositorio.save(legajo);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
	@Transactional
	public void eliminarVacunaLegajo(Integer idLegajo , Integer idVacuna) throws ErrorServicio {
		try {
			Legajo legajo = buscarId(idLegajo);
			Vacunas vacuna = vacunasServicios.buscarPorId(idVacuna);
			legajo.getVacunas().remove(vacuna);
			 legajoRepositorio.save(legajo);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
}
