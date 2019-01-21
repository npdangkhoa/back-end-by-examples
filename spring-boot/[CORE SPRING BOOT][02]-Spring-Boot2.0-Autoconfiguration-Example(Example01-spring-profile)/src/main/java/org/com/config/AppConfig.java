package org.com.config;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Then you can specify the active profile using System Property -Dspring.profiles.active=DEV.
 * 
 * This approach works for simple cases like enable or disable bean registrations based on activated 
 * profiles. But if you want to register beans based on some conditional logic then the profiles approach 
 * itself is not sufficient.
 * 
 * @author knguyen97
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	@Profile("dev")
	public DataSource devDataSource() {
		return null;
	}
	
	@Bean
	@Profile("pro")
	public DataSource proDataSource() {
		return null;
	}
}

