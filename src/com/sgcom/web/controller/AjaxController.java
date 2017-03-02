package com.sgcom.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgcom.web.service.CategoriaBO;

@Controller
public class AjaxController {
	
	@Autowired
	private CategoriaBO categoriaBO;
	
	
	
	final static Logger log = Logger.getLogger(CategoriaController.class);
	
	@RequestMapping("/ajaxGetCagetorias")
	public @ResponseBody String ajaxGetCagetorias(){
		log.info("Llamado asincrónico para obtener Categorias");
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this.categoriaBO.listCategorias());
		} catch (JsonProcessingException e) {
			log.info("Error en llamado asincrónico para obtener Categorias", e);
		}
		return "";
	}

}
