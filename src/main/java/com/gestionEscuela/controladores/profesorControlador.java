package com.gestionEscuela.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.gestionEscuela.entidades.Profesores;
import com.gestionEscuela.repositorios.ProfesorRepositorio;
import com.gestionEscuela.servicios.ProfesorServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/profesor")
public class profesorControlador {
	
	Boolean	altas=true; 
	
	@Autowired
	ProfesorServicios profesorServicio;
	
	@Autowired
	ProfesorRepositorio profesorRepositorio;
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("profesores/listaProfesor");
		model.put("altas",altas);
		return mav;
	}
	
	
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("profesores/agregarProfesor");
		return mav;
	}
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable String id,ModelMap model) {
		ModelAndView mav = new ModelAndView("profesores/editarProfesor");
		int idNumber = Integer.parseInt(id);
		Profesores profesor = profesorServicio.buscarPorId(idNumber);
		model.addAttribute("profesor",profesor);
		return mav;
	}
	
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Profesores> listaProfesores = profesorRepositorio.findAll();
		modelo.addAttribute("profesores", listaProfesores);
	}
	
	@PostMapping("/crearProfesor")
	public RedirectView crearProfesorMetodoPost(Model modelo, HttpSession httpSession,@RequestParam String nombre,@RequestParam String apellido,@RequestParam Integer dni,@RequestParam String domicilio,@RequestParam Integer telefono,@RequestParam String email,@RequestParam String posesion,@RequestParam Integer horasCatedras,@RequestParam String observacion) 
			throws ErrorServicio, ParseException {
		RedirectView rv = new RedirectView();
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
			// Se usa para pase un string a formato date
			Date posesionDate;
			posesionDate= formato.parse(posesion);
			profesorServicio.crearProfesor(nombre,apellido,  dni,  domicilio,  telefono,  email,posesionDate, horasCatedras,observacion);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			System.out.print(posesion);
			rv.setUrl("redirect:/profesor/lista");
			return rv;
		}
		rv.setUrl("/profesor/lista");
		return rv;
	}
	
	@PostMapping("/altaBaja")
	public String darAltaBaja( @RequestParam Integer id) throws ErrorServicio {
		profesorServicio.altaBaja(id);
		return "redirect:/profesor/lista";
	}
	
	@GetMapping("mostrarAlta")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {
		altas=profesorServicio.mostrarAlta(this.altas);
		return "redirect:/profesor/lista";
	}
	
	@GetMapping("mostrarBaja")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {
		altas=profesorServicio.mostrarBaja(this.altas);
		return "redirect:/profesor/lista";
	}
	
	@PostMapping("editar/profesor")
	public RedirectView editarVacunaMetodoPost(Model modelo, HttpSession httpSession, @RequestParam String nombre ,@RequestParam Integer id,@RequestParam String apellido,@RequestParam Integer dni,@RequestParam String domicilio,@RequestParam Integer telefono,@RequestParam String email, String posesion,@RequestParam Integer horasCatedras,@RequestParam String observacion) 
			throws ErrorServicio, ParseException {
		RedirectView rv = new RedirectView();
		try { 
			profesorServicio.editarProfesor(id,nombre,apellido,  dni,  domicilio,  telefono,email,posesion, horasCatedras,observacion);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/profesor/lista");
			return rv;
		}
		rv.setUrl("/profesor/lista");
		return rv;
	}
	@GetMapping("delete/{id}")
	public RedirectView deleteVacunaMetodoPost(Model modelo, HttpSession httpSession ,@PathVariable("id")Integer id ) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			profesorServicio.deleteProfesor(id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
			rv.setUrl("redirect:/");
			return rv;
		}
		rv.setUrl("/profesor/lista");
		return rv;
	}

}
