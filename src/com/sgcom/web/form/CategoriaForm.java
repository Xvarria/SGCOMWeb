package com.sgcom.web.form;

import com.sgcom.web.model.Categoria;
import com.sgcom.web.model.FormAcciones;

public class CategoriaForm extends BaseFormInfo{

	private Categoria categoria;

	public CategoriaForm(FormAcciones formAction) {
		super(formAction);
		this.categoria = new Categoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
