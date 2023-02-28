package com.gestionEscuela.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.entidades.NumeroCurricula;
import com.gestionEscuela.repositorios.MateriasRepositorio;
import com.gestionEscuela.repositorios.NumeroCurriculaRepositorio;
import com.gestionEscuela.servicios.NumeroCurriculaServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/numeroCurricula")
public class numeroCurriculaControlador {

	Boolean altas= false;
	
	@Autowired
	NumeroCurriculaRepositorio numeroCurriculaRepositorio;
	
	@Autowired
	NumeroCurriculaServicios numeroCurriculaServicio;
	
	@Autowired
	MateriasRepositorio materiasRepositorio;
	
	@GetMapping("lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("numeroCurricula/listaNumeroCurricula");
		model.put("altas",altas);
		
		
		return mav ;
	}
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("numeroCurricula/agregarNumeroCurricula");
		return mav;
	}
	
	
	@PostMapping("/crearNumeroCurricula")
	public RedirectView crearNumeroCurriculaMetodoPost(Model modelo, @RequestParam String nombre) 
			throws ErrorServicio {

		RedirectView rv = new RedirectView();
		try {
	
			numeroCurriculaServicio.crearNumeroCurricula(nombre);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/numeroCurricula/agregarMaterias");
			return rv;
		}
		rv.setUrl("/numeroCurricula/agregarMaterias");
		return rv;
	}
	
	@GetMapping("/agregarMaterias")
	public ModelAndView editar(ModelMap model) {
		ModelAndView mav = new ModelAndView("numeroCurricula/agregarMateriasNumeroCurricula");
		
		NumeroCurricula numeroCurricula = numeroCurriculaServicio.buscarUltima();
		List<Materias> materias = materiasRepositorio.findAll();
		model.addAttribute("numeroCurricula",numeroCurricula);
		model.addAttribute("materias",materias);
		return mav;
	}
	
	@PostMapping("/agregarMateriaListaCurricula")
	public RedirectView agregarMateriaNumeroCurriculaMetodoPost(Model modelo,@RequestParam  String idMateria ,@RequestParam  String idCurricula) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			int idNumberMateria = Integer.parseInt(idMateria);
			int idNumberCurricula = Integer.parseInt(idCurricula);
			numeroCurriculaServicio.agregarMateriaCurricula(idNumberCurricula,idNumberMateria);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/numeroCurricula/agregarMaterias");
			return rv;
		}
		rv.setUrl("/numeroCurricula/agregarMaterias");
		return rv;
	}
	
	@PostMapping("/eliminarMateriaListaCurricula")
	public RedirectView eliminarMateriaNumeroCurriculaMetodoPost(Model modelo,@RequestParam  String idMateria ,@RequestParam  String idCurricula) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			int idNumberMateria = Integer.parseInt(idMateria);
			int idNumberCurricula = Integer.parseInt(idCurricula);
			numeroCurriculaServicio.eliminarMateriaCurricula(idNumberCurricula,idNumberMateria);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/numeroCurricula/agregarMaterias");
			return rv;
		}
		rv.setUrl("/numeroCurricula/agregarMaterias");
		return rv;
	}
	
}
