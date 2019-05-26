package com.boraji.tutorial.spring02.dao;

import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entity.User;

@Repository
public class UserDaoImp extends AbstractUserDao<User> implements IUserDao {
	public UserDaoImp() {
		setClazz(User.class);
	}
}
