package com.sgcom.web.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgcom.web.model.Categoria;
import com.sgcom.web.service.CategoriaBO;

@Controller
public class AjaxController {
	
	@Autowired
	private CategoriaBO categoriaBO;
	
	final static Logger log = Logger.getLogger(CategoriaController.class);
	
	@RequestMapping("/ajaxGetCagetorias")
	public @ResponseBody String ajaxGetCagetorias() throws Exception{
		log.info("Llamado asincrónico para obtener Categorias");
		ObjectMapper mapper = new ObjectMapper();
		try {
			Collection<Categoria> categorias = this.categoriaBO.listCategorias();
			return mapper.writeValueAsString(categorias);
		} catch (JsonProcessingException e) {
			log.info("Error en llamado asincrónico para obtener Categorias", e);
			throw e;
		}
	}

}
