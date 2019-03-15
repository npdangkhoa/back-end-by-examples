package com.boraji.tutorial.spring03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
