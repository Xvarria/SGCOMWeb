package com.sgcom.web.validator;

import static com.sgcom.web.model.SGComConstansts.CAMPO_CATEGORIA_CODIGO;
import static com.sgcom.web.model.SGComConstansts.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sgcom.web.form.CategoriaForm;

@Component
public class CategoriaValidator implements Validator{
	
	final static Logger log = Logger.getLogger(CategoriaValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.debug("Inicio de validacion de categoria");
		//CategoriaForm command = (CategoriaForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, CAMPO_CATEGORIA_CODIGO, ERROR_CODIGO_VACIO);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, CAMPO_CATEGORIA_DESCRIPCION, ERROR_CATEGORIA_VAICA);	
		log.debug("Fin de validacion de categoria");
	}
}
