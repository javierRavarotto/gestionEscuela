package com.gestionEscuela.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionEscuela.entidades.ArticulosTomados;

@Repository
public interface ArticulosTomadosRepositorio extends JpaRepository <ArticulosTomados,Integer>  {

}