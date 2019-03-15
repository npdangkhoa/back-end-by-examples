package com.boraji.tutorial.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");

				// It makes the implementation easy and allows you to change the configuration
				// without changing the source code.
				// Hibernate loads the configuration file automatically from the classpath
				// when you call the configure method on the StandardServiceRegistryBuilder.
				registry = new StandardServiceRegistryBuilder().configure().applySettings(configuration.getProperties()).build();

				// create metadatasource
				MetadataSources source = new MetadataSources(registry);

				// create Meta Data
				Metadata metaData = source.getMetadataBuilder().build();

				// create sesssionFactory
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}

		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
