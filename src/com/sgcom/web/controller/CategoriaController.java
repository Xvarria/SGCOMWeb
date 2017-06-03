package com.sgcom.web.controller;

import static com.sgcom.web.model.SGComConstansts.ERROR_CATEGORIA_PARAMETRO_INVALIDO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sgcom.web.form.CategoriaForm;
import com.sgcom.web.form.ElementoLink;
import com.sgcom.web.model.Categoria;
import com.sgcom.web.model.FormAcciones;
import com.sgcom.web.model.exception.ParametroIncorrectoException;
import com.sgcom.web.service.CategoriaBO;
import com.sgcom.web.service.impl.UtilBO;
import com.sgcom.web.validator.CategoriaValidator;

@Controller
public class CategoriaController {
	
	final static Logger log = Logger.getLogger(CategoriaController.class);
	final static String FORM_VIEW = "categoriaForm";
	final static String ERROR_VIEW = "error";//TODO add this jsp
	final static String LISTAR_VIEW = "categoriaListar";
	
	
	@Autowired
	private CategoriaValidator categoriaValidator;
	
	@Autowired
	private CategoriaBO categoriaBO;
	
	@RequestMapping("/categoria/listar")
	public ModelAndView listarCategoria(){
		return new ModelAndView(LISTAR_VIEW) ;
	}
	
	@RequestMapping(value = "/categoria/agregar", method = RequestMethod.GET)
	public ModelAndView agregarCategoriaGet(){
		CategoriaForm form = new CategoriaForm(FormAcciones.AGREGAR, new Categoria());
		return new ModelAndView(FORM_VIEW, "form", form) ;
	}
	
	@RequestMapping(value = "/categoria/agregar", method = RequestMethod.POST)
	public ModelAndView agregarCategoriaPost(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("form") CategoriaForm form, BindingResult result) throws Exception {
		//String successView = this.procesarAccion(command, result);
		this.categoriaValidator.validate(form, result); //validates the form
		if (!result.hasErrors()) {
			try {
				Categoria categoria = form.getCategoriaDelForm();
				this.categoriaBO.save(categoria);
				//setea los valores de success message y las opciones respectivas
				form.setOpcion1(new ElementoLink("Agregar Otra Categoria","/categoria/agregar.do"));//TODO setear valores como costantes
				form.setOpcion2(new ElementoLink("Regresar","/categoria/listar.do"));//TODO setear valores como costantes
				form.setMensaje("Categoria Agregada exitosamente");
			} catch (Exception e) {
				log.error("Error al registrar en la base datos", e);
			}	
		}
		return new ModelAndView(FORM_VIEW, "form", form);
	}
	
	@RequestMapping(value = "/categoria/mostrar", method = RequestMethod.GET)
	public ModelAndView mostarCategoriaGet(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "categoriaId", required=true)String categoriaIdStr){
		return getFormCargado(categoriaIdStr, FormAcciones.MOSTRAR);	
	}
	
	@RequestMapping(value = "/categoria/actualizar", method = RequestMethod.GET)
	public ModelAndView actualizarCategoriaGet(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "categoriaId", required=true)String categoriaIdStr){
		return getFormCargado(categoriaIdStr, FormAcciones.ACTUALIZAR);	
	}
	
	//TODO extaer metodo del post y usar la accion del from para determinar el metodo que se va a usar del service.
	@RequestMapping(value = "/categoria/actualizar", method = RequestMethod.POST)
	public String actualizarCategoriaPost(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("form") CategoriaForm form, BindingResult result) throws Exception {
		this.categoriaValidator.validate(form, result); //validates the form
		if (!result.hasErrors()) {
			try {
				Categoria categoria = form.getCategoriaDelForm();
				this.categoriaBO.update(categoria);
				//setea los valores de success message y las opciones respectivas
				form.setOpcion1(new ElementoLink("Continuar la edicion",""));//TODO agregar tilde / caracteres
				form.setOpcion2(new ElementoLink("Regresar","/categoria/listar.do")); //TODO setear valores como costantes
				form.setMensaje("Categoria Agregada exitosamente");
			} catch (Exception e) {
				log.error("Error al registrar en la base datos", e);
			}	
		}
		return FORM_VIEW;
	}
	
	
	private ModelAndView getFormCargado(String categoriaIdStr, FormAcciones accion) {
		String mensajeError = "";
		try {
			int categoriaId = UtilBO.getIntParametro(categoriaIdStr);
			Categoria categoria = this.categoriaBO.getCategoriaById(categoriaId);
			CategoriaForm form = new CategoriaForm(accion, categoria);
			return new ModelAndView(FORM_VIEW, "form", form) ;
		} catch (ParametroIncorrectoException e) {
			mensajeError = "Parametro invalido para Categoria Id = " + categoriaIdStr;
			log.error(mensajeError, e);
			//define error message
		}
		return new ModelAndView(ERROR_VIEW, "mensajeError", ERROR_CATEGORIA_PARAMETRO_INVALIDO) ;
	}
}
