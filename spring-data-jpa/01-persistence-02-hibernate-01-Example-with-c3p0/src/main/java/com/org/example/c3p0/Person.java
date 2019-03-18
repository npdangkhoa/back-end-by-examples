package com.org.example.c3p0;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PERSON")
public class Person {
	
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String Name;

		
	public Person(String name) {
		super();
		Name = name;
	}
		
	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
