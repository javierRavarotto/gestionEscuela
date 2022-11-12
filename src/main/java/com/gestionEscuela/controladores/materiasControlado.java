package com.gestionEscuela.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/materias")
public class materiasControlado {

	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/listaMaterias");
		return mav;
	}
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/agregarMateria");
		return mav;
	}
}
