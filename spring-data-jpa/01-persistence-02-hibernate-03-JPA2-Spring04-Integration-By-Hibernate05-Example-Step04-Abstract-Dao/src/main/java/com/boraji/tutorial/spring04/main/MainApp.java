package com.boraji.tutorial.spring04.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.boraji.tutorial.spring00.config.AppConfig;
import com.boraji.tutorial.spring01.entity.Person;
import com.boraji.tutorial.spring03.Service.PersonService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		PersonService personService = context.getBean(PersonService.class);

		// Add Persons
		personService.add(new Person("Sunil", "Bora", "suni.bora@example.com"));
		personService.add(new Person("David", "Miller", "david.miller@example.com"));
		personService.add(new Person("Sameer", "Singh", "sameer.singh@example.com"));
		personService.add(new Person("Paul", "Smith", "paul.smith@example.com"));

		// Get Persons
		List<Person> persons = personService.listPersons();
		for (Person person : persons) {
			System.out.println("Id = " + person.getId());
			System.out.println("First Name = " + person.getFirstName());
			System.out.println("Last Name = " + person.getLastName());
			System.out.println("Email = " + person.getEmail());
			System.out.println();
		}

		context.close();
	}
}
