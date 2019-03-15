package com.boraji.tutorial.spring02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entity.User;

import org.hibernate.SessionFactory;

@Repository
public class UserDaoImp implements UserDao{

	@Autowired
	private SessionFactory session;
	
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
