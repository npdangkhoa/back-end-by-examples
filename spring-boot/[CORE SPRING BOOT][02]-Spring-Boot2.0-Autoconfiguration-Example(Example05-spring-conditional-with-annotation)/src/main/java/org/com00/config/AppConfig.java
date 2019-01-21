package org.com00.config;

import org.com01.dao.JdbcUserDAO;
import org.com01.dao.MongoUserDAO;
import org.com01.dao.UserDAO;
import org.com03.annotation.DatabaseType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * What if we want to register MongoUserDAO bean only if property app.dbType=MONGO is set in properties
 *  placeholder configuration file?
 * 
 * @author knguyen97
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	@DatabaseType("MYSQL")
	public UserDAO jdbcUserDao() {
		return new JdbcUserDAO();
	}
	
	@Bean
	@DatabaseType("MONGO")
	public UserDAO mongoDbDao() {
		return new MongoUserDAO();
	}

}

