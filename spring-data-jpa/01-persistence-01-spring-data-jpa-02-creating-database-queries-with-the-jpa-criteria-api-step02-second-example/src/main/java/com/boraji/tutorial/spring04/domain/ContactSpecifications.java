package com.boraji.tutorial.spring04.domain;

import org.springframework.data.jpa.domain.Specification;

import com.boraji.tutorial.spring01.entities.Contact;

public final class ContactSpecifications {
	private ContactSpecifications() {}
	
	public static Specification<Contact> hasFirstName(String name){
		return (root, query, cb) -> {
			return cb.like(cb.upper(root.get("firstName")),  name.toUpperCase());
			
		};
	}
}
