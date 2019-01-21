package org.com.config;

import org.com03.data.DataSource;
import org.com04.dao.EmployeeDAO;
import org.com05.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public EmployeeService employeeService() {
		return new EmployeeService(employeeDao());
	} 
	
	@Bean
	public EmployeeDAO employeeDao() {
		return new EmployeeDAO(dataSource);
	}
	
}
