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

@Repository
public class CategoriaDAOImpl extends AbstractDAO implements CategoriaDAO {

	@Override
	public void save(Categoria categoria) {
		persist(categoria);
	}

	@Override
	public void update(Categoria categoria) {
		getSession().update(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		getSession().delete(categoria);
	}

	@Override
	public Categoria getCategoriaById(int categoriaId) {
       
		CriteriaBuilder builder = this.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteriaQuery = this.getCriteriaBuilder().createQuery(Categoria.class);
		Root<Categoria> categoriaRoot = criteriaQuery.from(Categoria.class);
		criteriaQuery.select(categoriaRoot);
		criteriaQuery.where(builder.equal(categoriaRoot.get("categoriaId"),categoriaId));
		List<Categoria> listaCategorias = this.getEntityManager().createQuery(criteriaQuery).getResultList();

		Categoria categoria = null;
		if (!listaCategorias.isEmpty()){
			categoria = listaCategorias.iterator().next();
		}
		return categoria;
	}

	@Override
	public Collection<Categoria> listCategorias() {
		
        //Get Criteria Builder
        CriteriaBuilder builder = this.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> categoriaRoot = criteria.from(Categoria.class);
		criteria.select(categoriaRoot);
        //Use criteria to query with session to fetch all contacts
        Collection<Categoria> listaCategorias = getSession().createQuery(criteria).getResultList();

        return listaCategorias;
	}
}
