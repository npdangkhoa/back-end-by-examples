package com.boraji.tutorial.spring03.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.spring01.entity.Person;
import com.boraji.tutorial.spring02.Dao.IGenericDao;

@Service
public class PersonServiceImp implements PersonService {

	private IGenericDao<Person> dao;
	
	@Autowired
	public void setDao(IGenericDao<Person> daoToSet) {
		this.dao = daoToSet;
		dao.setClazz(Person.class);
	}
	
	@Transactional
	public void add(Person person) {
		dao.add(person);
	}

	@Transactional
	public List<Person> listPersons() {
		return dao.findAll();
	}

}
