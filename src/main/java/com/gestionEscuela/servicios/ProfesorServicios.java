 package com.gestionEscuela.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Articulos;
import com.gestionEscuela.entidades.ArticulosTomados;
import com.gestionEscuela.entidades.Profesores;
import com.gestionEscuela.repositorios.ArticulosRepositorio;
import com.gestionEscuela.repositorios.ArticulosTomadosRepositorio;
import com.gestionEscuela.repositorios.ProfesorRepositorio;

import errorServicio.ErrorServicio;

@Service
public class ProfesorServicios {
	
	@Autowired
	private ProfesorRepositorio profesorRepositorio;
	@Autowired
	ArticulosTomadosRepositorio articulosTomadosRepositorio;
	@Autowired
	ArticulosRepositorio articuloRepositorio;
	@Autowired
	ArticulosServicios articuloServicios;
	
	public Profesores buscarPorId(Integer id) {
		Profesores profesor = profesorRepositorio.findById(id).get();
		return profesor;
	}
	@Transactional
	public void crearProfesor( String nombre, String apellido, Integer dni, String domicilio, Integer telefono, String email,Date posesionDate, Integer horasCatedras, String observacion) throws ErrorServicio {
		try {
			Profesores profesor = new Profesores();
			ArticulosTomados articulosTomados = new ArticulosTomados();
			profesor.setNombre(nombre);
			profesor.setApellido(apellido);
			profesor.setDni(dni);
			profesor.setDomicilio(domicilio);
			profesor.setTelefono(telefono);
			profesor.setEmail(email);
			profesor.setTomaposesion(posesionDate);
			profesor.setHorascatedrastotales(horasCatedras);
			profesor.setObservaciones(observacion);
			profesor.setAlta(true);
			profesor.setFechaCreacion(new Date());
			profesor.setFechaEdit(new Date());
			
			articulosTomados.setAlta(true);
			articulosTomados.setFechaCreacion(new Date());
			articulosTomados.setFechaEdit(new Date());
			profesor.setArticulos(articulosTomados);
			articulosTomadosRepositorio.save(articulosTomados);
			profesorRepositorio.save(profesor);
		} catch (Exception e) {
			
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

	@Transactional
	public void editarProfesor(Integer id, String nombre , String apellido, Integer dni, String domicilio, Integer telefono, String email,String posesion, Integer horasCatedras, String observacion) throws ErrorServicio {
		try {
			Profesores profesor = buscarPorId(id);
			
			
			if(posesion != "") {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
				Date posesionDate;
				posesionDate= formato.parse(posesion);
				System.out.print(posesion+  "uno ");
				profesor.setNombre(nombre);
				profesor.setApellido(apellido);
				profesor.setDni(dni);
				profesor.setDomicilio(domicilio);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setTomaposesion(posesionDate);
				profesor.setHorascatedrastotales(horasCatedras);
				profesor.setObservaciones(observacion);
				profesor.setFechaEdit(new Date());
				profesorRepositorio.save(profesor);
			}else {
				System.out.print(posesion + " dos");
				profesor.setNombre(nombre);
				profesor.setApellido(apellido);
				profesor.setDni(dni);
				profesor.setDomicilio(domicilio);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setHorascatedrastotales(horasCatedras);
				profesor.setObservaciones(observacion);
				profesor.setFechaEdit(new Date());
				profesorRepositorio.save(profesor);
			}
				
				
			
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void deleteProfesor(Integer id) throws ErrorServicio {
		try {
			Profesores profesor = buscarPorId(id);
			profesorRepositorio.delete(profesor);	
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void altaBaja(Integer id)throws ErrorServicio {
		Profesores profesor = profesorRepositorio.findById(id).get();

		if(profesor.getAlta()==true) {
			profesor.setAlta(false);
		}else {
			profesor.setAlta(true);
		}
		profesorRepositorio.save(profesor);	
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
	public void agregarArticuloTomado(Integer idArticulo , Integer idProfesor) throws ErrorServicio {
		try {
			Profesores profesor = buscarPorId(idProfesor);
			Articulos articulo = articuloServicios.buscarPorId(idArticulo);
			ArticulosTomados articuloTomado= articulosTomadosRepositorio.findById(profesor.getArticulos().getIdArticuloTomado()).get();
			articuloTomado.getArticulo().add(articulo);
		
			articulosTomadosRepositorio.save(articuloTomado); 
			articuloRepositorio.save(articulo); 
			System.out.print( articuloTomado.getArticulo());
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	@Transactional
	public void eliminarArticuloTomado(Integer idArticulo , Integer idProfesor) throws ErrorServicio {
		try {
			Profesores profesor = buscarPorId(idProfesor);
			Articulos articulo = articuloServicios.buscarPorId(idArticulo);
			ArticulosTomados articuloTomado= articulosTomadosRepositorio.findById(profesor.getArticulos().getIdArticuloTomado()).get();
			
			articuloTomado.getArticulo().remove(articulo);
			 profesorRepositorio.save(profesor);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
	@Transactional
	public Set<Articulos> contadorArticlosToamdos(Integer idProfesor) throws ErrorServicio {
		try {
			Profesores profesor = buscarPorId(idProfesor);
			ArticulosTomados articuloTomado= articulosTomadosRepositorio.findById(profesor.getArticulos().getIdArticuloTomado()).get();
			
			Integer id=0;
			List<Articulos> articulos = articuloTomado.getArticulo();
			Set<Articulos> setArticulos = new HashSet<>(Set.of());
			for (Articulos articulo : articulos) {
				if(id!=articulo.getIdArticulo()) {
					 id=articulo.getIdArticulo();
					articulo.setCantidad(0);
				};
				articulo.setCantidad(articulo.getCantidad()+1);
			}
			setArticulos.addAll(articulos);
			articulosTomadosRepositorio.save(articuloTomado);
			 profesorRepositorio.save(profesor);
			 return setArticulos;
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
		
	}
}
