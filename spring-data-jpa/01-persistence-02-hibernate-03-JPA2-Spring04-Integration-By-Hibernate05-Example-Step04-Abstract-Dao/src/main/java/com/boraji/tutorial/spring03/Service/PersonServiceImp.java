package com.boraji.tutorial.spring03.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.spring01.entity.Person;
import com.boraji.tutorial.spring02.Dao.PersonDao;

@Service
public class PersonServiceImp implements PersonService {

	@Autowired
	private PersonDao dao;
	
	@Transactional
	public void add(Person person) {
		dao.add(person);
	}

	@Transactional
	public List<Person> listPersons() {
		return dao.listPersons();
	}

}
