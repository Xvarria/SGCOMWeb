package com.sgcom.web.service;

import java.util.Collection;

import com.sgcom.web.model.Categoria;

public interface CategoriaBO {
	
	public void save(Categoria categoria);
	
	public void update(Categoria categoria);
	
	public void delete(Categoria categoria);
	
	public Categoria getCategoriaById(int categoriaId);
	
	public Collection<Categoria> listCategorias();
}
