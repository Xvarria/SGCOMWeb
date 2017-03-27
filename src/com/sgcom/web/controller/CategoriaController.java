package com.sgcom.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sgcom.web.form.CategoriaForm;
import com.sgcom.web.model.Categoria;
import com.sgcom.web.model.FormAcciones;
import com.sgcom.web.service.CategoriaBO;
import com.sgcom.web.validator.CategoriaValidator;

@Controller
public class CategoriaController {
	
	final static Logger log = Logger.getLogger(CategoriaController.class);
	
	@Autowired
	private CategoriaValidator categoriaValidator;
	
	@Autowired
	private CategoriaBO categoriaBO;
	
	@RequestMapping("/categoria/listar")
	public ModelAndView listarCategoria(){
		String successView = "categoriaListar";
		return new ModelAndView(successView) ;
	}
	
	@RequestMapping(value = "/categoria/agregar", method = RequestMethod.GET)
	public ModelAndView agregarCategoriaGet(){
		CategoriaForm form = new CategoriaForm(FormAcciones.AGREGAR, new Categoria());
		String successView = "categoriaForm";
		return new ModelAndView(successView, "form", form) ;
	}
	
	@RequestMapping(value = "/categoria/agregar", method = RequestMethod.POST)
	public String agregarCategoriaPost(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("form") CategoriaForm form, BindingResult result) throws Exception {
		//String successView = this.procesarAccion(command, result);
		String successView = "categoriaForm";
		this.categoriaValidator.validate(form, result); //validates the form
		if (!result.hasErrors()) {
			try {
				Categoria categoria = form.getCategoriaDelForm();
				this.categoriaBO.save(categoria);
			} catch (Exception e) {
				log.error("Error al registrar en la base datos");
			}	
		}

		return successView;
	}		

/*
	private String procesarAccion(CategoriaForm command, BindingResult result) {
		boolean errorOnPost=false;
		String nextView = "NEXT VIEW"; //TODO agregar next view
		//String message = "";
		//Limpar mensajes de command
		//command.getMessageAndRedirect().cleanMsgValue(); //Cleans message and redirect info
		//Agregar opciones de dropDown, esto se puede hace desde otro método
		this.categoriavalidator.validate(command, result); //validates the form
		if (result.hasErrors()) {
			errorOnPost = true;
		} else {
			//String logEntryOnError = "";
			//String errorPropertyKey = "";
			//String successPropertyKey = "";
			FormAcciones accion = FormAcciones.getAccion(command.getAccion());
			try {				
				switch (accion){
				case AGREGAR:
					Categoria categoria = new Categoria();
					this.categoriaBO.save(categoria);
					break;
				default:
					break;
				}
			}catch(Exception e){
				//log.error(logEntryOnError, e);
				errorOnPost = true;
				//this.familyPagesFormValidator.setErrorAtException(result, errorPropertyKey);//TODO crear método con error de validacion genérico
			}

			if (!errorOnPost){
				//message = this.propertyMessageService.getMessageFromProperties(successPropertyKey);
				//command.getMessageAndRedirect().setSuccessMessage(message);//Set success message
				//if (actionType == Actions.ACTION_CREATE){
				//	command.setFamilyPage(new FamilyPage());
				//}
			}			
		}			
		return nextView;
	}
*/	
	
}
