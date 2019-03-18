package com.boraji.tutorial.spring03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring01.entity.User;
import com.boraji.tutorial.spring02.dao.IUserDao;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private IUserDao dao;

	@Transactional
	public void add(User user) {
		dao.add(user);
	}

	@Transactional(readOnly = true)
	public List<User> listUsers() {
		return dao.listUser();
	}


}
