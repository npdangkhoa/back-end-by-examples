package com.boraji.tutorial.spring01.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contact.class)
public class Contact_ {
    public static volatile SingularAttribute<Contact, Long> id;
    public static volatile SingularAttribute<Contact, String> firstName; 
    public static volatile SingularAttribute<Contact, String> lastName;
    public static volatile SingularAttribute<Contact, String> phoneNumber;
    public static volatile SingularAttribute<Contact, String> phoneType;
}
