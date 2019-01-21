package com.boraji.tutorial.spring03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring01.entity.User;
import com.boraji.tutorial.spring02.generic.dao.hibernate.IGenericDao;

@Service
public class UserServiceImp implements IUserService {

	private IGenericDao<User> dao;

	@Autowired
	public void setDao(IGenericDao<User> daoToSet) {
		dao = daoToSet;
		dao.setClazz(User.class);
	}
	
	@Transactional
	public void add(User user) {
		dao.add(user);
	}

	@Transactional(readOnly = true)
	public List<User> listUsers() {
		return dao.FindAll();
	}



}
