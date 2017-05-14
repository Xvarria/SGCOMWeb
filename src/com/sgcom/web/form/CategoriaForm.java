package com.sgcom.web.form;

import java.io.InvalidClassException;

import com.sgcom.web.model.Categoria;
import com.sgcom.web.model.FormAcciones;

public class CategoriaForm extends BaseFormInfo{
	
	private String categoriaId;
	private String codigo;
	private String descripcion;
	
	public CategoriaForm() {
		super();
	}

	public CategoriaForm(FormAcciones accion, Categoria categoria) {
		super();
		this.setAccion(accion.getDesc());
		this.categoriaId = String.valueOf(categoria.getCategoriaId());
		this.codigo = categoria.getCodigo();
		this.descripcion = categoria.getDescripcion();
	}

	public String getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(String categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Categoria getCategoriaDelForm() throws InvalidClassException{
		Categoria categoria = new Categoria();
		categoria.setCategoriaId(Integer.parseInt(this.categoriaId));
		categoria.setCodigo(this.getCodigo());
		categoria.setDescripcion(this.getDescripcion());
		return categoria;
	}
}
