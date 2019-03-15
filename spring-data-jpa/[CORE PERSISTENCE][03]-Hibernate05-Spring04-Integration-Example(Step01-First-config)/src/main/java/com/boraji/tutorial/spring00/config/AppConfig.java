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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.boraji.tutorial.spring01.entity.User;

@Configuration
@PropertySource("classpath:db.properties")
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
}
