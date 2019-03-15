package com.boraji.tutorial.spring02.Dao;

import java.util.List;

import com.boraji.tutorial.spring01.entity.Person;

public interface PersonDao {
	
	void add(Person person);

	List<Person> listPersons();
}
