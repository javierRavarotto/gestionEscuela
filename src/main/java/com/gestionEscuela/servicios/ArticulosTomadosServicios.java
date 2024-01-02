package com.gestionEscuela.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEscuela.entidades.ArticulosTomados;
import com.gestionEscuela.entidades.Profesores;
import com.gestionEscuela.repositorios.ArticulosTomadosRepositorio;

import errorServicio.ErrorServicio;

@Service
public class ArticulosTomadosServicios {
	
	@Autowired
	ArticulosTomadosRepositorio articulosTomadosRepositorio;
	
	
	
	public ArticulosTomados buscarPorId(Integer id) {
		ArticulosTomados articulosTomados = articulosTomadosRepositorio.findById(id).get();
		return articulosTomados;
	}
	
	

}