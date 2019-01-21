package org.com05.service;

import java.util.List;

import org.com02.domain.Employee;
import org.com04.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public List<Employee> getEmployeeDetails() {
		return employeeDAO.getEmployeeDetails();
	}
}
