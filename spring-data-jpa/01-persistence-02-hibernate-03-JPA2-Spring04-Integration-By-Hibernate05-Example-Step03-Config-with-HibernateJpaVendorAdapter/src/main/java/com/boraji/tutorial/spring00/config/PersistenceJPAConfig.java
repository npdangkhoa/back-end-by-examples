package com.boraji.tutorial.spring00.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configurable
@ComponentScans(value = { @ComponentScan("com.boraji.tutorial.spring03.Service"),
						  @ComponentScan("com.boraji.tutorial.spring02.Dao") })
public class PersistenceJPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean containEntityManager = new LocalContainerEntityManagerFactoryBean();
		containEntityManager.setDataSource(getDataSource());
		containEntityManager.setPackagesToScan(new String[] {"com.boraji.tutorial.spring01.entity"});
		containEntityManager.setJpaProperties(getProperties());
		
		// java.lang.IllegalArgumentException: No PersistenceProvider specified in EntityManagerFactory configuration, 
		// and chosen PersistenceUnitInfo does not specify a provider class name either
		containEntityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return containEntityManager;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");		
		return properties;
	}
	
	
}
