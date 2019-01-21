package com.boraji.tutorial.spring03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.spring01.entity.User;
import com.boraji.tutorial.spring02.dao.UserDao;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void add(User user) {
		userDao.add(user);
	}

	public List<User> listUsers() {
		return userDao.listUser();
	}

}
