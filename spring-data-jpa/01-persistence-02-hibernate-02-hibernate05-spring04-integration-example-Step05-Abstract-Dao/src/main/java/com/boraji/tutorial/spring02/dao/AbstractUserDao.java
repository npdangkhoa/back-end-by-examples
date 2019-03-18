package com.boraji.tutorial.spring02.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.boraji.tutorial.spring01.entity.User;

public abstract class AbstractUserDao <T extends Serializable> {

	private Class<T> clazz;
	
	@Autowired
	private SessionFactory session;
	
	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet; 
	}
	
	public void add(final T entity) {
		session.getCurrentSession().persist(entity);
	}
	
	public List<User> listUser(){
		return getCurrentSessionFactory()
				.createQuery("from " + clazz.getName()).list();
	}

	
	protected final Session getCurrentSessionFactory() {
		return session.getCurrentSession();
	}
}
