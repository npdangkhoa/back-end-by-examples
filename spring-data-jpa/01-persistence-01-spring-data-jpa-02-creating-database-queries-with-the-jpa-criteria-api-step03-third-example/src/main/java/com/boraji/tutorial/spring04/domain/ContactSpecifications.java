package com.boraji.tutorial.spring04.domain;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.boraji.tutorial.spring01.entities.Contact;
import com.boraji.tutorial.spring01.entities.Contact_;

public final class ContactSpecifications {
	private ContactSpecifications() {}
	
	public static Specification<Contact> hasFirstName(String name){
		return (root, query, cb) -> {
			return cb.like(cb.upper(root.get("firstName")),  name.toUpperCase());
			
		};
	}
	
	public static Specification<Contact> titleOrDescriptionContainsIgnoreCase(String searchTerm) {
		Specification<Contact> spec = new Specification<Contact>() {

			@Override
			public Predicate toPredicate(Root<Contact> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.or(
						cb.like(cb.lower(root.get(Contact_.firstName)), "%" + searchTerm + "%"),
						cb.like(cb.lower(root.get(Contact_.lastName)), "%" +  searchTerm + "%")
						);
			}
		};
		
		return spec;
	}
}
