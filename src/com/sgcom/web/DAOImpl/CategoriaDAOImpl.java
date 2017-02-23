package com.sgcom.web.DAOImpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.sgcom.web.DAO.AbstractDAO;
import com.sgcom.web.DAO.CategoriaDAO;
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

        //Get Criteria Builder
        CriteriaBuilder builder = getSession().getCriteriaBuilder();

		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> categoriaRoot = criteria.from(Categoria.class);
		criteria.select(categoriaRoot);

        //Use criteria to query with session to fetch all contacts
        Collection<Categoria> listaCategorias = getSession().createQuery(criteria).getResultList();

		ParameterExpression<Integer> categoriaIdParam = builder.parameter(Integer.class);
		criteria.where(builder.equal(categoriaRoot.get(Categoria_.categoriaId), categoriaIdParam));
		TypedQuery<Categoria> query = builder.createQuery(criteria);
		query.setParameter(categoriaIdParam, categoriaId);
        //Use criteria to query with session to fetch all contacts
        Collection<Categoria> listaCategorias = getSession().createQuery(criteria).getResultList();

        return listaCategorias.iterator().next();
	}

	@Override
	public Collection<Categoria> listCategorias() {
		
        //Get Criteria Builder
        CriteriaBuilder builder = getSession().getCriteriaBuilder();

		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> categoriaRoot = criteria.from(Categoria.class);
		criteria.select(categoriaRoot);

        //Use criteria to query with session to fetch all contacts
        Collection<Categoria> listaCategorias = getSession().createQuery(criteria).getResultList();

        return listaCategorias;
	}
}
