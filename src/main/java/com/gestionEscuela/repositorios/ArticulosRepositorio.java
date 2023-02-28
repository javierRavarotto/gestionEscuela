package com.gestionEscuela.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionEscuela.entidades.Articulos;

@Repository
public interface ArticulosRepositorio extends JpaRepository <Articulos,Integer>  {

}
