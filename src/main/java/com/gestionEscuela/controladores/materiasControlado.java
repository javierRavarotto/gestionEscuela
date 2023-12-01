package com.gestionEscuela.controladores;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.gestionEscuela.repositorios.MateriasRepositorio;
import com.gestionEscuela.servicios.MateriasServicios;
import com.gestionEscuela.servicios.NumeroCurriculaServicios;

import errorServicio.ErrorServicio;



@Controller
@RequestMapping("/materias")
public class materiasControlado {
	Boolean	altas=true;
	
	@Autowired
	MateriasServicios materiasServicio;
	
	@Autowired
	MateriasRepositorio materiasRepositorio;

	
	@Autowired
	NumeroCurriculaServicios numeroCurriculaServicio;




	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/listaMaterias");
		model.put("altas",altas);
		String mensaje="";
		model.addAttribute("error",mensaje);
		return mav;
	}
	@GetMapping("/listaError")
	public ModelAndView listaError(ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/listaMaterias");
		model.put("altas",altas);
		String mensaje="La materia se encuentra en una curricula";
		model.addAttribute("error",mensaje);
		return mav;
	}
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/agregarMateria");
		return mav;
	}

	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Materias> listaMaterias = materiasRepositorio.findAll();
		
		modelo.addAttribute("materias", listaMaterias);
	}
	
	@PostMapping("/crearMateria")
	public RedirectView crearMateriaMetodoPost(Model modelo, @RequestParam String nombre,@RequestParam String formato,@RequestParam Integer cantidadHoras,@RequestParam String modalidadCursaro) 

			throws ErrorServicio {

		RedirectView rv = new RedirectView();
		try {
	

			Materias newMateria =materiasServicio.crearMateria(nombre,formato,cantidadHoras,modalidadCursaro);
			
			if(newMateria != null ) {
				rv.setUrl("/materias/lista");
			}else {
				rv.setUrl("redirect:/materias/lista");
			}
			
			return rv;
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/materias/lista");
			return rv;
		}
		
	}
	@GetMapping("mostrarAlta")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {

		altas=materiasServicio.mostrarAlta(this.altas);
		return "redirect:/materias/lista";
	}
	
	@GetMapping("mostrarBaja")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {

		altas=materiasServicio.mostrarBaja(this.altas);
		return "redirect:/materias/lista";
	}
	@PostMapping("/altaBaja")
	public String darAltaBaja( @RequestParam Integer id) throws ErrorServicio {
		materiasServicio.altaBaja(id);
		return "redirect:/materias/lista";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable String id,ModelMap model) {
		ModelAndView mav = new ModelAndView("materias/editarMateria");
		int idNumber = Integer.parseInt(id);
		Materias materia = materiasServicio.buscarId(idNumber);
		model.addAttribute("materia",materia);
		return mav;
	}
	
	@PostMapping("editar/materia")
	public RedirectView editarMateriaMetodoPost(Model modelo, HttpSession httpSession,@RequestParam Integer id , @RequestParam String nombre,@RequestParam String formato,@RequestParam Integer cantidadHoras,@RequestParam String modalidadCursaro) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			materiasServicio.editarMateria(id,nombre,formato,cantidadHoras,modalidadCursaro);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/materias/lista");
			return rv;
		}
		rv.setUrl("/materias/lista");
		return rv;
	}
	

	@GetMapping("delete/{id}")
	public RedirectView deleteMateriasMetodoPost(Model modelo, HttpSession httpSession ,@PathVariable("id")Integer id ) 
			throws DataIntegrityViolationException,ErrorServicio,ConstraintViolationException{
		RedirectView rv = new RedirectView();
		try {
			materiasServicio.deleteMateria(id);
			rv.setUrl("/materias/lista");
		} catch (DataIntegrityViolationException e) {

			rv.setUrl("/materias/listaError");
		}
		
		return rv;
	}
	
	@PostMapping("editar/eliminarMateriaListaCurricula")
	public RedirectView eliminarMateriaNumeroCurriculaMetodoPost(Model modelo,@RequestParam  String idMateria ,@RequestParam  String idCurricula) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			int idNumberMateria = Integer.parseInt(idMateria);
			int idNumberCurricula = Integer.parseInt(idCurricula);
			numeroCurriculaServicio.eliminarMateriaCurricula(idNumberCurricula,idNumberMateria);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/materias/editar");
			return rv;
		}
		rv.setUrl("/materias/editar/" + idMateria );
		return rv;
	}
	

}
