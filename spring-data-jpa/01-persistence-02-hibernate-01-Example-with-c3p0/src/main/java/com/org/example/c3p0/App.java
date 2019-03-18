package com.org.example.c3p0;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	private static Session session;
	private static Transaction transaction;

	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		try {
			transaction.begin();

			Person person = new Person("Mike Lewis");
			session.save(person);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}

			HibernateUtil.shutdown();
		}
	}
}
