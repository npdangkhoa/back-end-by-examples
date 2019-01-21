package org.com.config;

import org.com01.condition.DevDataSourceCondition;
import org.com01.condition.ProDataSourceCondition;
import org.com03.data.DataSource;
import org.com03.data.DataSourceDev;
import org.com03.data.DataSourcePro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeDataSourceConfig {

	@Bean
	@Conditional(value=ProDataSourceCondition.class)
	public DataSource proDataSource() {
		return new DataSourcePro();
	}
	
	@Bean
	@Conditional(value=DevDataSourceCondition.class)
	public DataSource devDataSource() {
		return new DataSourceDev();
	}
	
}
