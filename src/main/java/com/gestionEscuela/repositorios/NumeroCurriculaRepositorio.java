package com.gestionEscuela.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestionEscuela.entidades.NumeroCurricula;

@Repository
public interface NumeroCurriculaRepositorio extends JpaRepository <NumeroCurricula,Integer> {

	@Query(value="SELECT max(m) FROM NumeroCurricula m  ")
	public NumeroCurricula buscarUltima();
	
}
