package org.com04.dao;

import java.util.List;

import org.com02.domain.Employee;
import org.com03.data.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDAO {
	
	@Autowired
	private DataSource dataSource;

	public EmployeeDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Employee> getEmployeeDetails() {
		return dataSource.getEmployeeDetails();
	}
}
