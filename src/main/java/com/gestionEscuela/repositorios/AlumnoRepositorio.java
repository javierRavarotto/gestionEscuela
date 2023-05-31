package com.gestionEscuela.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionEscuela.entidades.Alumnos;

@Repository
public interface AlumnoRepositorio extends JpaRepository <Alumnos,Integer>  {

}
