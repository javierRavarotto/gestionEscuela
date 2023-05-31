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

import com.gestionEscuela.entidades.Legajo;
import com.gestionEscuela.entidades.Vacunas;
import com.gestionEscuela.repositorios.LegajoRepositorio;
import com.gestionEscuela.repositorios.VacunasRepositorio;
import com.gestionEscuela.servicios.LegajoServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/legajos")
public class legajoControlador {

	Boolean	altas=true;  
	
	@Autowired
	LegajoServicios legajoServicio;
	
	@Autowired
	LegajoRepositorio legajoRepositorio;
	
	@Autowired
	VacunasRepositorio vacunasRepositorio;
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Legajo> listaLegajos = legajoRepositorio.findAll();
		modelo.addAttribute("legajos", listaLegajos);
	}
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("legajos/listaLegajo");
		model.put("altas",altas);
		return mav;
	}
	
	@GetMapping("/agregar/{id}")
	public ModelAndView agregar(ModelMap model,@PathVariable("id") Integer id) {
		System.out.print(id);
		ModelAndView mav = new ModelAndView("legajos/agregarLegajo");
		model.put("idAlumno",id);
		return mav;
	}

	@PostMapping("agregar/crearLegajo")
	public RedirectView crearLegajoMetodoPost(Model modelo,Integer idAlumno,  Boolean partidaNacimiento ,
			 Boolean fotocopiaDNI , Boolean tituloSecundario , 
			 Boolean cooperadora , @RequestParam String descripcionTitulo,
			@RequestParam String descripcionCooperadora, @RequestParam String anotaciones) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		
		try {
			legajoServicio.crearLegajo(idAlumno,partidaNacimiento,fotocopiaDNI,tituloSecundario,cooperadora,descripcionTitulo,descripcionCooperadora,anotaciones);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/legajos/lista");
			return rv;
		}
		 Legajo legajo = legajoServicio.buscarUltima();
		 
		 if(legajo.getIdLegajo() != null) {
			 Integer id = legajo.getIdLegajo();
			}
		
		rv.setUrl("/alumnos/editar/" + idAlumno );
		return rv;
	}
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable String id,ModelMap model) {
		ModelAndView mav = new ModelAndView("legajos/editarLegajo");
		Integer idNumber = Integer.parseInt(id);
		List<Vacunas> vacunas = vacunasRepositorio.findAll();
		if(legajoServicio.buscarId(idNumber) != null) {
			Legajo legajo = legajoServicio.buscarId(idNumber);
			model.addAttribute("legajo",legajo);
		}

		model.addAttribute("vacunas",vacunas);
		return mav;
	}
	@PostMapping("editar/legajo")
	public RedirectView editarArticuloMetodoPost(Model modelo, HttpSession httpSession,Integer id, Boolean partidaNacimiento ,
			 Boolean fotocopiaDNI , Boolean tituloSecundario , 
			 Boolean cooperadora , @RequestParam String descripcionTitulo,
			@RequestParam String descripcionCooperadora, @RequestParam String anotaciones) 
			throws ErrorServicio {

		RedirectView rv = new RedirectView();
		try {
			legajoServicio.editarLegajo(id,partidaNacimiento,fotocopiaDNI,tituloSecundario,cooperadora,descripcionTitulo,descripcionCooperadora,anotaciones);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/legajos/lista");
			return rv;
		}
		rv.setUrl("/legajos/lista");
		return rv;
	}
	@PostMapping("/altaBaja")
	public String darAltaBaja( @RequestParam Integer id) throws ErrorServicio {
		legajoServicio.altaBaja(id);
		return "redirect:/legajos/lista";
	}
	@GetMapping("mostrarAlta")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {

		altas=legajoServicio.mostrarAlta(this.altas);
		return "redirect:/legajos/lista";
	}
	
	@GetMapping("mostrarBaja")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {

		altas=legajoServicio.mostrarBaja(this.altas);
		return "redirect:/legajos/lista";
	}
	@GetMapping("delete/{id}")
	public RedirectView deleteVacunaMetodoPost(Model modelo, HttpSession httpSession ,@PathVariable("id")Integer id ) 
			throws ErrorServicio {
	
		RedirectView rv = new RedirectView();
		try {
			legajoServicio.deleteLegajo(id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
			rv.setUrl("redirect:/");
			return rv;
		}
		rv.setUrl("/legajos/lista");
		return rv;
	}
	
	@PostMapping("editar/agregarVacunaLegajo")
	public RedirectView agregarMateriaNumeroCurriculaMetodoPost(Model modelo,@RequestParam  Integer idLegajo ,@RequestParam  Integer idVacuna) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
		
			legajoServicio.agregarVacunaLegajo(idLegajo,idVacuna);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/legajos/editar/" + idLegajo);
			return rv;
		}
		rv.setUrl("/legajos/editar/" + idLegajo);
		return rv;
	}
	
	@PostMapping("editar/eliminarVacunaLegajo")
	public RedirectView eliminarMateriaNumeroCurriculaMetodoPost(Model modelo,@RequestParam Integer idLegajo ,@RequestParam  Integer idVacuna) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			legajoServicio.eliminarVacunaLegajo(idLegajo,idVacuna);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/legajos/editar/"+ idLegajo);
			return rv;
		}
		rv.setUrl("/legajos/editar/"+ idLegajo);
		return rv;
	}
}
