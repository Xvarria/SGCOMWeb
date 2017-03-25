package com.sgcom.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sgcom.web.form.CategoriaForm;
import com.sgcom.web.model.FormAcciones;

@Controller
public class CategoriaController {
	
	final static Logger log = Logger.getLogger(CategoriaController.class);
	
	@RequestMapping("/categoria/listar")
	public ModelAndView listarCategoria(){
		String successView = "categoriaListar";
		return new ModelAndView(successView) ;
	}
	
	@RequestMapping(value = "/categoria/agregar", method = RequestMethod.GET)
	public ModelAndView agregarCategoriaGet(){
		CategoriaForm form = new CategoriaForm(FormAcciones.AGREGAR);
		String successView = "categoriaForm";
		return new ModelAndView(successView, "form", form) ;
	}	

}
