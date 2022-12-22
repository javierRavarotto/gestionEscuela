package com.gestionEscuela.controladores;

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

import com.gestionEscuela.repositorios.MateriasRepositorio;
import com.gestionEscuela.servicios.MateriasServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/materias")
public class materiasControlado {
	Boolean	altas=true;
	
	@Autowired
	MateriasServicios materiasServicio;
	
	@Autowired
	MateriasRepositorio materiasRepositorio;
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/listaMaterias");
		model.put("altas",altas);
		return mav;
	}
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/agregarMateria");
		return mav;
	}
	
	@PostMapping("/crearMateria")
	public RedirectView crearMateriaMetodoPost(Model modelo, @RequestParam String nombre) 
			throws ErrorServicio {

		RedirectView rv = new RedirectView();
		try {
	
			materiasServicio.crearMateria(nombre);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/materias/lista");
			return rv;
		}
		rv.setUrl("/materias/lista");
		return rv;
	}
	
	
}
