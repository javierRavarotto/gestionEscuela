package com.gestionEscuela.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionEscuela.entidades.Materias;

@Repository
public interface MateriasRepositorio extends JpaRepository <Materias,Integer> {

}
