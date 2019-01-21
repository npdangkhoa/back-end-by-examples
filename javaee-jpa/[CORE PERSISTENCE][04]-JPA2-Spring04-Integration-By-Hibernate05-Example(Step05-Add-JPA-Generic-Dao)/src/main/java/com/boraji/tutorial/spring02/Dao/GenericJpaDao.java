package com.boraji.tutorial.spring02.Dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entity.Person;

@Repository
public class GenericJpaDao<T extends Serializable> extends AbstractJpaDAO<T> implements IGenericDao<T> {

}
