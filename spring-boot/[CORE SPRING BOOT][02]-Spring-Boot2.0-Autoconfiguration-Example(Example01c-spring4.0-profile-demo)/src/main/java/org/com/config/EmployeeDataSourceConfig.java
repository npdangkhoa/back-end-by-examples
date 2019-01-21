package org.com.config;


import org.com03.data.DataSource;
import org.com03.data.DataSourceDev;
import org.com03.data.DataSourcePro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author knguyen97
 *We can use @Profile annotation at @Bean methods level, we don’t need two separate classes to work with two 
 *different databases. We can define two @Bean methods in the same class. Combine both Dev and Prod data 
 *source definitions into one class. As we cannot use same method name and signature twice in same class
 * to define two different data sources, we need to use different method names, but define @Bean’s “name” 
 * attribute as shown below.
 */
@Configuration
public class EmployeeDataSourceConfig  {
	
	@Bean(name="dataSource")
	@Profile("dev")
	public DataSource getDevDataSource() {
		return new DataSourceDev();
	}

	
	@Bean(name="dataSource")
	@Profile("prod")
	public DataSource getPRoDataSource() {
		return new DataSourcePro();
	}
	
}

