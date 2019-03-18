package com.boraji.tutorial.spring03.Service;

import java.util.List;

import com.boraji.tutorial.spring01.entity.Person;

public interface PersonService {
	
	void add(Person person);

	List<Person> listPersons();
}
