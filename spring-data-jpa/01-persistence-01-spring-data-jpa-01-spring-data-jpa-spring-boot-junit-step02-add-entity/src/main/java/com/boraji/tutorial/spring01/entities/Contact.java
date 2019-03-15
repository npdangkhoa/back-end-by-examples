package com.boraji.tutorial.spring01.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
 
    @Column(name = "First_Name")
    private String firstName;
 
    @Column(name = "Last_Name")
    private String lastName;
 
    @Column(name = "Email")
    private String email;

    @Column(name = "Phone_Number")
    private String phoneNumber;
    
    @Column (name ="Phone_Type")
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;
    

    
	public Contact(String firstName, String lastName, String email, PhoneType phoneType, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
	}
	
	public Contact() {
		super();
	}
	

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
 
    
}
