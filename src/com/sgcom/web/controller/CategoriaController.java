package com.sgcom.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaController {
	
	final static Logger log = Logger.getLogger(CategoriaController.class);
	
	@RequestMapping("/categoria/listar")
	public ModelAndView listarCategorias(){
		String successView = "categoriaListar";
		return new ModelAndView(successView) ;
	}
	
	

}
