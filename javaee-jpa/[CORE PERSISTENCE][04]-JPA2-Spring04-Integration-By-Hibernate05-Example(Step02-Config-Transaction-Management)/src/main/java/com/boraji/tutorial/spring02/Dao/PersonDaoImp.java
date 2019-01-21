package com.boraji.tutorial.spring02.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entity.Person;

@Repository
public class PersonDaoImp implements PersonDao{

	//The @PersistenceContext annotation is used to inject the EntityManager object into DOA classes.
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	public void add(Person person) {
		entityManager.persist(person);
	}

	public List<Person> listPersons() {
		CriteriaQuery<Person> criterial = entityManager.getCriteriaBuilder().createQuery(Person.class);
		Root<Person> root = criterial.from(Person.class);
		return entityManager.createQuery(criterial).getResultList();
	}

}
