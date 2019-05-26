package com.boraji.tutorial.spring02.generic.dao.hibernate;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {
	
	public void setClazz(final Class<T> clazzToSet);
		
	void add(T entity);

	List<T> FindAll();
}
