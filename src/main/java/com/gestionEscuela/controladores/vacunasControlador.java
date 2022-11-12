package com.gestionEscuela.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.gestionEscuela.entidades.Vacunas;
import com.gestionEscuela.repositorios.VacunasRepositorio;
import com.gestionEscuela.servicios.VacunasServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/vacunas")
public class vacunasControlador {

	@Autowired
	VacunasServicios vacunasServicio;
	
	@Autowired
	VacunasRepositorio vacunasRepositorio;
	
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("vacunas/listaVacunas");
		return mav;
	}
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("vacunas/agregarVacuna");
		return mav;
	}
	
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Vacunas> listaVacunas = vacunasRepositorio.findAll();
		modelo.addAttribute("vacunas", listaVacunas);
	}
	
	@PostMapping("/crearVacuna")
	public RedirectView crearVacunaMetodoPost(Model modelo, HttpSession httpSession, @RequestParam String nombre
			) throws ErrorServicio {
		RedirectView rv = new RedirectView();
		

		
		try {
			vacunasServicio.crearVacuna(nombre);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/");
			return rv;
		}
		rv.setUrl("/");
		return rv;
	}
	
}
