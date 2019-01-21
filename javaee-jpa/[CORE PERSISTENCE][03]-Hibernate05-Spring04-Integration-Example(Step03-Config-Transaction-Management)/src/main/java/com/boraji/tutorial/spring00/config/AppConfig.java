package com.boraji.tutorial.spring00.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.boraji.tutorial.spring01.entity.User;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScans(value = { 
		@ComponentScan("com.boraji.tutorial.spring02.dao"),
		@ComponentScan("com.boraji.tutorial.spring03.service") })
@EnableTransactionManagement
public class AppConfig {
	@Autowired
	private Environment env;

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

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());

		factory.setHibernateProperties(getProperties());
		factory.setAnnotatedClasses(User.class);
		return factory;
	}
	

	/**
	 * Exception in thread "main" org.hibernate.HibernateException: 
	 * Could not obtain transaction-synchronized Session for current thread.
	 * Solution: You must enable the transaction support 
	 * (<tx:annotation-driven> or @EnableTransactionManagement) 
	 * and declare the transactionManager and it should work through the SessionFactory.
	 * You must add @Transactional into your @Repository
	 * @return
	 */
	@Bean 	
	HibernateTransactionManager getTransationManager() {
		HibernateTransactionManager transactionManager = new  HibernateTransactionManager();
		transactionManager.setSessionFactory(this.getSessionFactory().getObject());
		return transactionManager;
	}

}
