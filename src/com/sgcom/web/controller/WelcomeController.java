package com.sgcom.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sgcom.web.service.CategoriaBO;

@Controller
public class WelcomeController {

	@Autowired
	private CategoriaBO categoriaBO;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		this.categoriaBO.listCategorias();
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
}
