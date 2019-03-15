package com.boraji.tutorial.spring02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entity.User;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory session;
	
	
	public void add(User user) {
		session.getCurrentSession().save(user);
		
	}

	public List<User> listUser() {
		Query<User> query = session.getCurrentSession().createQuery("from user");
		return query.getResultList();
	}

}
