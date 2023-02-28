package com.gestionEscuela.controladores;

<<<<<<< HEAD
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

import com.gestionEscuela.entidades.Articulos;
import com.gestionEscuela.entidades.Vacunas;
import com.gestionEscuela.repositorios.ArticulosRepositorio;
import com.gestionEscuela.servicios.ArticulosServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/articulos")
public class articulosControlador {
	Boolean	altas=true;  //puede ser false
	
	@Autowired
	ArticulosServicios articulosServicio;
	
	@Autowired
	ArticulosRepositorio articulosRepositorio;
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("articulos/listaArticulos");
		model.put("altas",altas);
		return mav;
	}
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Articulos> listaArticulos = articulosRepositorio.findAll();
		modelo.addAttribute("articulos", listaArticulos);
	}
	
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("articulos/agregarArticulo");
		return mav;
	}
	@PostMapping("/crearArticulo")
	public RedirectView crearArticuloMetodoPost(Model modelo, @RequestParam String nombre, @RequestParam String descripcion) 
			throws ErrorServicio {
		RedirectView rv = new RedirectView();
		try {
			articulosServicio.crearArticulo(nombre,descripcion);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/articulos/lista");
			return rv;
		}
		rv.setUrl("/articulos/lista");
		return rv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable String id,ModelMap model) {
		ModelAndView mav = new ModelAndView("articulos/editarArticulo");
		int idNumber = Integer.parseInt(id);
		Articulos articulos = articulosServicio.buscarPorId(idNumber);
		model.addAttribute("articulo",articulos);
		return mav;
	}
	
	@PostMapping("editar/articulo")
	public RedirectView editarArticuloMetodoPost(Model modelo, HttpSession httpSession, @RequestParam String nombre ,@RequestParam Integer id,@RequestParam String descripcion) 
			throws ErrorServicio {

		RedirectView rv = new RedirectView();
		try {
	
			articulosServicio.editarArticulo(nombre,id,descripcion);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			modelo.addAttribute("nombre", nombre);
			rv.setUrl("redirect:/articulos/lista");
			return rv;
		}
		rv.setUrl("/articulos/lista");
		return rv;
	}
	
	@PostMapping("/altaBaja")
	public String darAltaBaja( @RequestParam Integer id) throws ErrorServicio {
		articulosServicio.altaBaja(id);
		return "redirect:/articulos/lista";
	}
	@GetMapping("mostrarAlta")
	public String mostrarAlta(ModelMap modelo) throws ErrorServicio {

		altas=articulosServicio.mostrarAlta(this.altas);
		return "redirect:/articulos/lista";
	}
	
	@GetMapping("mostrarBaja")
	public String mostrarBaja(ModelMap modelo) throws ErrorServicio {

		altas=articulosServicio.mostrarBaja(this.altas);
		return "redirect:/articulos/lista";
	}
	@GetMapping("delete/{id}")
	public RedirectView deleteVacunaMetodoPost(Model modelo, HttpSession httpSession ,@PathVariable("id")Integer id ) 
			throws ErrorServicio {
	
		RedirectView rv = new RedirectView();
		try {
			 System.out.println(id);
			articulosServicio.deleteArticulo(id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
			rv.setUrl("redirect:/");
			return rv;
		}
		rv.setUrl("/articulos/lista");
		return rv;
	}
=======
public class articulosControlador {
>>>>>>> 0867d048ab1a88a6e17a417c52558aae2aad6bcb

}
