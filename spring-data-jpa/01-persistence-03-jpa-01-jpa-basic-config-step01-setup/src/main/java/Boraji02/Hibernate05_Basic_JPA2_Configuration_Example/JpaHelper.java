package Boraji02.Hibernate05_Basic_JPA2_Configuration_Example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaHelper {
	
	private static final String PERSISTENCE_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		} 
		return factory;
	}
	
	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}
