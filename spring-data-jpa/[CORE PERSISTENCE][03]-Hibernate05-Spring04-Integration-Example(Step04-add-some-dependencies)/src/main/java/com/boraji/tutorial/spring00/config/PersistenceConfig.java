package com.boraji.tutorial.spring00.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource({"classpath:db.properties"})
@ComponentScan({"com.boraji.tutorial.spring02.dao", 
			    "com.boraji.tutorial.spring03.service"})
public class PersistenceConfig {
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(getProperties());
		// Exception in thread "main" org.springframework.beans.factory.BeanCreationException: 
		// Error creating bean with name 'getSessionFactory' defined in com.boraji.tutorial.spring00.config.PersistenceConfig: 
		// Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: 
		// Failed to instantiate [org.springframework.orm.hibernate4.LocalSessionFactoryBean]:
		// Factory method 'getSessionFactory' threw exception; nested exception is java.lang.Error: Unresolved compilation problem: 
		// factory.setAnnotatedClasses(User.class);
		
		factory.setPackagesToScan(new String[] {"com.boraji.tutorial.spring01.entity"});
		return factory;
	}
	
	
	@Bean
	public DataSource getDataSource() {
		// The @PropertySource annotation is used to add any source of key-value pairs
		// to spring’s Environment.
		// The Environment object represents the spring environment in which the current
		// application is running.
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(env.getProperty("db.driver"));
		source.setUrl(env.getProperty("db.url"));
		source.setUsername(env.getProperty("db.username"));
		source.setPassword(env.getProperty("db.password"));

		return source;
	}

	@Bean
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		return properties;

	}


}
