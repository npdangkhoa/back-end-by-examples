package com.boraji.tutorial.spring02.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDAO<T extends Serializable> {
	
	private Class<T> clazz;
	
	
	//The @PersistenceContext annotation is used to inject the EntityManager object into DOA classes.
	@PersistenceContext
	private EntityManager entityManager;
	
	
	//TODO: clazz.getName() will be NULL if we don't have method setClazz
	public void setClazz(Class<T> pClazz) {
		this.clazz = pClazz;
	}
	
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public void add(T entity) {
		this.getEntityManager().persist(entity);
	}

	public List<T> findAll(){
		return this.getEntityManager().createQuery("from " + clazz.getName()).getResultList();
	}

}
