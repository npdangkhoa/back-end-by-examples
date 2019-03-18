package com.boraji.tutorial.spring03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entities.Contact;
import com.boraji.tutorial.spring01.entities.PhoneType;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
	List<Contact> findByLastNameAndPhoneType(String lastName, PhoneType type);

}
