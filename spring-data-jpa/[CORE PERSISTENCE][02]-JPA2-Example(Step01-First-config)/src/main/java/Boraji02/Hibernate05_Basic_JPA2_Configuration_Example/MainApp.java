package Boraji02.Hibernate05_Basic_JPA2_Configuration_Example;

import javax.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class MainApp {
	public static String CHECK_VERSION = "SELECT H2VERSION() FROM DUAL";

	
	public static void main( String[] args ) {
    	EntityManager manager = JpaHelper.getEntityManagerFactory().createEntityManager();
    	manager.getTransaction().begin();
    	String result = (String) manager.createNativeQuery(CHECK_VERSION).getSingleResult();
    	System.out.println(result);
    	manager.getTransaction().commit();
    	manager.close();
    	JpaHelper.shutdown();
    }
}
