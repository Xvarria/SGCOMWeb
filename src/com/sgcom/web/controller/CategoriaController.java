package com.sgcom.web.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sgcom.web.model.Categoria;
import com.sgcom.web.service.CategoriaBO;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaBO categoriaBO;
	
	final static Logger log = Logger.getLogger(CategoriaController.class);
	
	@RequestMapping("/categoria/listar")
	public ModelAndView listarCategorias(){
		String successView = "CategoriaListar";
		Collection<Categoria> categorias = this.categoriaBO.listCategorias();
		return new ModelAndView(successView, "lista", categorias) ;
	}
	
	

}
