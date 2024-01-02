package com.gestionEscuela.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.Articulos;
import com.gestionEscuela.entidades.Vacunas;
import com.gestionEscuela.repositorios.ArticulosRepositorio;

import errorServicio.ErrorServicio;

@Service
public class ArticulosServicios {
	
	@Autowired
	private ArticulosRepositorio articulosRepositorio;
	

	@Transactional
	public void crearArticulo(String nombre,String descripcion) throws ErrorServicio {
		try {
			Articulos articulo = new Articulos();
			articulo.setNombre(nombre);
			articulo.setDescripcion(descripcion);
			articulo.setAlta(true);
			articulo.setFechaCreacion(new Date()); 
			articulo.setCantidad(0);
			articulosRepositorio.save(articulo);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
public Articulos buscarPorId(Integer id) {
		
		Articulos articulo = articulosRepositorio.findById(id).get();
		
		return articulo;
	}

@Transactional
public void editarArticulo(String nombre,Integer id,String descripcion) throws ErrorServicio {
	try {
		Articulos articulo = buscarPorId(id);
		articulo.setNombre(nombre);
		if(descripcion != "") {
			articulo.setDescripcion(descripcion);
		}
		articulosRepositorio.save(articulo);
	} catch (Exception e) {
		throw new ErrorServicio("Todos los campos son obligatorios");
	}
}
@Transactional
public void altaBaja(Integer id)throws ErrorServicio {
	Articulos articulo = articulosRepositorio.findById(id).get();

	if(articulo.getAlta()==true) {
		articulo.setAlta(false);
	}else {
		articulo.setAlta(true);
	}
	articulosRepositorio.save(articulo);	
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
public void deleteArticulo(Integer id) throws ErrorServicio {
	try {
		Articulos articulo = buscarPorId(id);
		articulosRepositorio.delete(articulo);
	} catch (Exception e) {
		throw new ErrorServicio("Todos los campos son obligatorios");
	}
}

}
