package com.boraji.tutorial.spring02.Dao;

import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entity.Person;

@Repository
public class PersonDaoImp extends AbstractPersonDAO<Person> implements PersonDao {
	
	//TODO: clazz.getName() will be NULL if we don't have method setClazz
	public PersonDaoImp() {
		this.setClazz(Person.class);
	}

}
