package com.boraji.tutorial.spring02.dao;

import java.util.List;

import com.boraji.tutorial.spring01.entity.User;

public interface UserDao {
	void add(User user);
	List<User> listUser();
}
