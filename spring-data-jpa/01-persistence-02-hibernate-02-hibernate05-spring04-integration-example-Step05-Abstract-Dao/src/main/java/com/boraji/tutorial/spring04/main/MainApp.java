package com.boraji.tutorial.spring04.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.boraji.tutorial.spring00.config.AppConfig;
import com.boraji.tutorial.spring01.entity.User;
import com.boraji.tutorial.spring03.service.UserService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService service = context.getBean(UserService.class);

		// Add Users
		service.add(new User("Sunil", "Bora", "suni.bora@example.com"));
		service.add(new User("David", "Miller", "david.miller@example.com"));
		service.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
		service.add(new User("Paul", "Smith", "paul.smith@example.com"));

		 // Get Users
	      List<User> users = service.listUsers();
	      for (User user : users) {
	         System.out.println("Id = "+user.getId());
	         System.out.println("First Name = "+user.getFirstName());
	         System.out.println("Last Name = "+user.getLastName());
	         System.out.println("Email = "+user.getEmail());
	         System.out.println();
	      }

	      context.close();
	}
}
