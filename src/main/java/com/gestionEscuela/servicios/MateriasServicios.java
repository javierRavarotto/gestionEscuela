package com.gestionEscuela.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionEscuela.repositorios.MateriasRepositorio;

@Service
public class MateriasServicios {
	
	@Autowired
	private MateriasRepositorio materiasRepositorio;

}
