package com.boraji.tutorial.spring02.generic.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao <T extends Serializable> {

	private Class<T> clazz;
	
	@Autowired
	private SessionFactory session;
	
	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet; 
	}
	
	public void add(final T entity) {
		session.getCurrentSession().persist(entity);
	}
	
	public List<T> FindAll(){
		return getCurrentSessionFactory()
				.createQuery("from " + clazz.getName()).list();
	}

	
	protected final Session getCurrentSessionFactory() {
		return session.getCurrentSession();
	}
}
