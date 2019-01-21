package org.com.config;


import org.com03.data.DataSource;
import org.com03.data.DataSourceDev;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author knguyen97
 *
 */
@Configuration
@Profile("dev")
public class DevEmployeeConfig {
	
	@Bean
	public DataSource dataSource() {
		return new DataSourceDev();
	}

}

