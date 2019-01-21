package org.com00.config;

import org.com01.dao.JdbcUserDAO;
import org.com01.dao.MongoUserDAO;
import org.com01.dao.UserDAO;
import org.com02.condition.MongoDBDatabaseTypeCondition;
import org.com02.condition.MySQLDatabaseTypeCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
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
	@Conditional(MySQLDatabaseTypeCondition.class)
	public UserDAO jdbcUserDao() {
		return new JdbcUserDAO();
	}
	
	@Bean
	@Conditional(MongoDBDatabaseTypeCondition.class)
	public UserDAO mongoDbDao() {
		return new MongoUserDAO();
	}

}

