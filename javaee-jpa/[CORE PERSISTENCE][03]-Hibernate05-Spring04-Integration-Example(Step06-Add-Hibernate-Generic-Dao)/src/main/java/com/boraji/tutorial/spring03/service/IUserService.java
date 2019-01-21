package com.boraji.tutorial.spring03.service;

import java.util.List;

import com.boraji.tutorial.spring01.entity.User;
import com.boraji.tutorial.spring02.generic.dao.hibernate.IGenericDao;

public interface IUserService {
	
	void setDao(IGenericDao<User> gernericDao);
	
	void add(User user);

	List<User> listUsers();
}
