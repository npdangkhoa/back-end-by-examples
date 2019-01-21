package com.boraji.tutorial.spring02.Dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

	public void setClazz(Class<T> pClazz);

	void add(T entity);

	List<T> findAll();
}
