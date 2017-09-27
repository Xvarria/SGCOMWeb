package com.sgcom.web.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.sgcom.web.dao.AbstractDAO;
import com.sgcom.web.dao.CategoriaDAO;
import com.sgcom.web.model.Categoria;
import com.sgcom.web.model.Categoria_;


@Repository
public class CategoriaDAOImpl extends AbstractDAO implements CategoriaDAO {
	
	@Override
	public void save(Categoria categoria) {
		super.save(categoria);
	}

	@Override
	public void update(Categoria categoria) {
		super.update(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		
		super.delete(categoria);
	}

	//Importante en Hibernate 5 se requiere la dependencia para 
	//hibernate-jpamodelgen y su respectivo plugin en el POM
	//Para Eliminar errorer de IDE se requiere en las opciones de "Compiler" permitir 
	//procesamiento de annotaciones y agregar la opcion target/metamodel
	//https://docs.jboss.org/hibernate/orm/5.0/topical/html/metamodelgen/MetamodelGenerator.html
	@Override
	public Categoria getCategoriaById(int categoriaId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> root = criteria.from(Categoria.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get(Categoria_.categoriaId), categoriaId));

		List<Categoria> listaCategorias = entityManager.createQuery(criteria).getResultList();

		Categoria categoria = null;
		if (!listaCategorias.isEmpty()) {
			categoria = listaCategorias.iterator().next();
		}
		return categoria;
	}

	@Override
	public Collection<Categoria> listCategorias() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> root = criteria.from(Categoria.class);
		criteria.select(root);
		return entityManager.createQuery(criteria).getResultList();		
	}
}