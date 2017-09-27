package com.sgcom.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
 
@Repository
public abstract class AbstractDAO {
 
	@PersistenceContext(name="persistenceUnit")
	protected EntityManager entityManager;

 
    protected void save(Object entity) {
    	this.entityManager.persist(entity);
    }
 
    protected void delete(Object entity) {
    	this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));
    }
    
    protected void update(Object entity) {
    	this.entityManager.merge(entity);
    }
}