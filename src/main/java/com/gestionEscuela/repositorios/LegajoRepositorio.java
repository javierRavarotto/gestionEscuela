package com.gestionEscuela.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestionEscuela.entidades.Legajo;
import com.gestionEscuela.entidades.NumeroCurricula;

@Repository
public interface LegajoRepositorio  extends JpaRepository <Legajo,Integer>  {
	@Query(value="SELECT max(l) FROM Legajo l  ")
	public Legajo buscarUltima();
	
}
