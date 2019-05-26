package com.spring03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.spring01.entities.Company;
import com.spring01.entities.Contact;

public interface ContactQuerydslRepository extends JpaRepository<Contact, Long>, QueryDslPredicateExecutor<Contact> {

    public List<Contact> findByCompany(Company company);

}
