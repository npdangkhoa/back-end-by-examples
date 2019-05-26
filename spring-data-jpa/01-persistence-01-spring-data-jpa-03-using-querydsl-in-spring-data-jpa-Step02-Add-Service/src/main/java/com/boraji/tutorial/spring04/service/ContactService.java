package com.boraji.tutorial.spring04.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.spring01.entities.Company;
import com.boraji.tutorial.spring01.entities.Contact;
import com.boraji.tutorial.spring01.entities.ContactType;
import com.boraji.tutorial.spring01.entities.generated.QContact;
import com.boraji.tutorial.spring03.repository.ContactQuerydslRepository;
import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;

@Service
public class ContactService {

	@Autowired
	private ContactQuerydslRepository contactDslRepo;

	
    public List<Contact> searchByName(String firstName, String lastName) {
    	QContact qContact = QContact.contact;

    	BooleanBuilder where = new BooleanBuilder();
    	
    	where.and(qContact.firstName.contains(firstName));
    	where.and(qContact.lastName.contains(lastName));
    	
    	Iterable<Contact> iterableContact = contactDslRepo.findAll(where);
    	
    	return Lists.newArrayList(iterableContact);
    }

	
	
	public Contact save(Company company, String firstName, String lastName, ContactType type) {

		Contact contact = new Contact();
		contact.setCompany(company);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setType(type);

		return contactDslRepo.save(contact);
	}

	public void delete(Contact contact) {
		contactDslRepo.delete(contact);
	}
}
