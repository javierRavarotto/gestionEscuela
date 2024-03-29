package com.gestionEscuela.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	Boolean	altas=false;
	@Autowired
	VacunasServicios vacunasServicio;
	
	@Autowired
	VacunasRepositorio vacunasRepositorio;
	
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("vacunas/listaVacunas");
		model.put("altas",altas);
		return mav;
	}
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("vacunas/agregarVacuna");
		return mav;
	}
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable String id,ModelMap model) {
		ModelAndView mav = new ModelAndView("vacunas/editarVacuna");
		int idNumber = Integer.parseInt(id);
		Vacunas vacunas = vacunasServicio.buscarPorId(idNumber);
		model.addAttribute("vacuna",vacunas);
		return mav;
	}
	
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Vacunas> listaVacunas = vacunasRepositorio.findAll();
		
		modelo.addAttribute("vacunas", listaVacunas);
	}
	
	@PostMapping("/crearVacuna")
	public RedirectView crearVacunaMetodoPost(Model modelo, HttpSession httpSession, @RequestParam String nombre) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			vacunasServicio.crearVacuna(nombre);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/vacunas/lista");
			return rv;
		}
		rv.setUrl("/vacunas/lista");
		return rv;
	}
	
	@PostMapping("/altaBaja")
	public String darAltaBaja( @RequestParam Integer id) throws ErrorServicio {
		vacunasServicio.altaBaja(id);
		return "redirect:/vacunas/lista";
	}
	
	@GetMapping("mostrarAlta")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {
		altas=vacunasServicio.mostrarAlta(this.altas);
		return "redirect:/vacunas/lista";
	}
	
	@GetMapping("mostrarBaja")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {

		altas=vacunasServicio.mostrarBaja(this.altas);
		return "redirect:/vacunas/lista";
	}
	
	@PostMapping("editar/vacuna")
	public RedirectView editarVacunaMetodoPost(Model modelo, HttpSession httpSession, @RequestParam String nombre ,@RequestParam Integer id) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
	
			vacunasServicio.editarVacuna(nombre,id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/vacunas/lista");
			return rv;
		}
		rv.setUrl("/vacunas/lista");
		return rv;
	}
	@GetMapping("delete/{id}")
	public RedirectView deleteVacunaMetodoPost(Model modelo, HttpSession httpSession ,@PathVariable("id")Integer id ) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			vacunasServicio.deleteVacuna(id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/");
			return rv;
		}
		rv.setUrl("/vacunas/lista");
		return rv;
	}


}
