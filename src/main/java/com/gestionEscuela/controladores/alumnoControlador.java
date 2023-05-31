package com.gestionEscuela.controladores;

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

import com.gestionEscuela.entidades.Alumnos;
import com.gestionEscuela.entidades.Legajo;
import com.gestionEscuela.repositorios.AlumnoRepositorio;
import com.gestionEscuela.servicios.AlumnoServicio;
import com.gestionEscuela.servicios.LegajoServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/alumnos")
public class alumnoControlador {
	Boolean	altas=true;
	@Autowired
	AlumnoServicio alumnoServicio;
	
	@Autowired
	LegajoServicios legajoServicio;
	
	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Alumnos> listaAlumnos = alumnoRepositorio.findAll();
		modelo.addAttribute("alumnos", listaAlumnos);
	}
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("alumnos/listaAlumno");
		model.put("altas",altas);
		return mav;
	}
	
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("alumnos/agregarAlumno");
		return mav;
	}
	@PostMapping("/crearAlumno")
	public RedirectView crearArticuloMetodoPost(Model modelo, @RequestParam String nombre, @RequestParam String apellido,
			@RequestParam Integer dni, @RequestParam Integer telefono, @RequestParam String domicilio, @RequestParam String email, 
			@RequestParam String observaciones) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			alumnoServicio.crearAlumno(nombre,apellido,dni,telefono,domicilio,email,observaciones);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/alumnos/lista");
			return rv;
		}
		rv.setUrl("/alumnos/lista");
		return rv;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Integer id,ModelMap model) throws ErrorServicio {
		ModelAndView mav = new ModelAndView("alumnos/editarAlumno");
		Alumnos alumno = alumnoServicio.buscarId(id); 
		if(legajoServicio.buscarUltima() != null) {
			Legajo legajo = legajoServicio.buscarUltima();
			Integer IdLegajo= legajo.getIdLegajo() +1;
			alumnoServicio.agregarLegajoAlumno(id, IdLegajo);
		}
	
		
		model.addAttribute("alumno",alumno);
		return mav;
	}
	
	@PostMapping("editar/alumno")
	public RedirectView editarArticuloMetodoPost(Model modelo, HttpSession httpSession,@RequestParam Integer id,  @RequestParam String nombre, @RequestParam String apellido,
			@RequestParam Integer dni, @RequestParam Integer telefono, @RequestParam String domicilio, @RequestParam String email, 
			@RequestParam String observacion) 
			throws ErrorServicio {

		RedirectView rv = new RedirectView();
		try {
	
			alumnoServicio.editarAlumno( id, nombre , apellido,  dni,telefono,domicilio,   email, observacion);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/alumnos/lista");
			return rv;
		}
		rv.setUrl("/alumnos/lista");
		return rv;
	}
	
	
	@PostMapping("/altaBaja")
	public String darAltaBaja( @RequestParam Integer id) throws ErrorServicio {
		alumnoServicio.altaBaja(id);
		return "redirect:/alumnos/lista";
	}
	
	@GetMapping("mostrarAlta")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {

		altas=alumnoServicio.mostrarAlta(this.altas);
		 System.out.println(altas);
		return "redirect:/alumnos/lista";
	}
	
	@GetMapping("mostrarBaja")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {

		altas=alumnoServicio.mostrarBaja(this.altas);
		 System.out.println(altas);
		return "redirect:/alumnos/lista";
	}
	@GetMapping("delete/{id}")
	public RedirectView deleteAlumnoMetodoPost(Model modelo, HttpSession httpSession ,@PathVariable("id")Integer id ) 
			throws ErrorServicio {
	
		RedirectView rv = new RedirectView();
		try {
			 
			alumnoServicio.deleteAlumno(id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
			rv.setUrl("redirect:/");
			return rv;
		}
		rv.setUrl("/alumnos/lista");
		return rv;
	}
}
