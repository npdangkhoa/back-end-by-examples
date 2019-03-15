package com.boraji.tutorial.hibernate;

import org.hibernate.Session;

public class MainApp {

	public static String CHECK_VERSION = "SELECT H2VERSION() FROM DUAL";
	public static void main(String[] args) {
		Session session = HibernateHelper.getSessionFactory().openSession();
		session.beginTransaction();
		
		String result = (String)session.createNativeQuery(CHECK_VERSION).getSingleResult();
	
		System.out.println(result);
		session.getTransaction().commit();
		session.close();
		
		HibernateHelper.shutdown();

	}

}
