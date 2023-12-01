package com.gestionEscuela.controladores;

import java.util.List;
import java.util.Optional;

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

import com.gestionEscuela.entidades.Materias;
import com.gestionEscuela.entidades.NumeroCurricula;
import com.gestionEscuela.repositorios.MateriasRepositorio;
import com.gestionEscuela.repositorios.NumeroCurriculaRepositorio;
import com.gestionEscuela.servicios.NumeroCurriculaServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/numeroCurricula")
public class numeroCurriculaControlador {

	Boolean altas= true;
	
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
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<NumeroCurricula> listaNumeroCurricula = numeroCurriculaRepositorio.findAll();
		
		modelo.addAttribute("numeroCurricula", listaNumeroCurricula);
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
			NumeroCurricula numeroCurricula =  numeroCurriculaServicio.crearNumeroCurricula(nombre);
			rv.setUrl("/numeroCurricula/editar/" + numeroCurricula.getIdCurricula());
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/numeroCurricula/agregarMaterias");
			return rv;
		}
	
	
		
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
	
	@PostMapping("editar/agregarMateriaListaCurricula")
	public RedirectView agregarMateriaNumeroCurriculaMetodoPost(Model modelo,@RequestParam  Integer idMateria ,@RequestParam  Integer idCurricula) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			
			numeroCurriculaServicio.agregarMateriaCurricula(idCurricula,idMateria);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/numeroCurricula/editar/" + idCurricula);
			return rv;
		}
		rv.setUrl("/numeroCurricula/editar/" + idCurricula);
		return rv;
	}
	
	@PostMapping("editar/eliminarMateriaListaCurricula")
	public RedirectView eliminarMateriaNumeroCurriculaMetodoPost(Model modelo,@RequestParam  Integer idMateria ,@RequestParam  Integer idCurricula) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			
			numeroCurriculaServicio.eliminarMateriaCurricula(idCurricula,idMateria);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/numeroCurricula/editar/"+ idCurricula);
			return rv;
		}
		rv.setUrl("/numeroCurricula/editar/" + idCurricula);
		return rv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Integer id,ModelMap model) {
		ModelAndView mav = new ModelAndView("numeroCurricula/editarNumeroCurricula");
		NumeroCurricula numeroCurricula = numeroCurriculaServicio.buscarId(id);
		List<Materias> materias = materiasRepositorio.findAll();
		model.addAttribute("numeroCurricula",numeroCurricula);
		model.addAttribute("materias",materias);
		return mav;
	}
	@PostMapping("editar/numeroCurricula")
	public RedirectView editarVacunaMetodoPost(Model modelo, HttpSession httpSession, @RequestParam String nombre ,@RequestParam Integer id) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
	
			numeroCurriculaServicio.editarNumeroCurricula(nombre,id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/numeroCurricula/lista");
			return rv;
		}
		rv.setUrl("/numeroCurricula/lista");
		return rv;
	}
	
	@PostMapping("/altaBaja")
	public String darAltaBaja( @RequestParam Integer id) throws ErrorServicio {
		numeroCurriculaServicio.altaBaja(id);
		return "redirect:/numeroCurricula/lista";
	}
	
	@GetMapping("mostrarAlta")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {
		altas=numeroCurriculaServicio.mostrarAlta(this.altas);
		return "redirect:/numeroCurricula/lista";
	}
	
	@GetMapping("mostrarBaja")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {
		altas=numeroCurriculaServicio.mostrarBaja(this.altas);
		return "redirect:/numeroCurricula/lista";
	}
	@GetMapping("delete/{id}")
	public RedirectView deleteNumeroCurriculaMetodoPost(Model modelo, HttpSession httpSession ,@PathVariable("id")Integer id ) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			numeroCurriculaServicio.deleteNumeroCurricula(id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
			rv.setUrl("redirect:/");
			return rv;
		}
		rv.setUrl("/numeroCurricula/lista");
		return rv;
	}
	
}
