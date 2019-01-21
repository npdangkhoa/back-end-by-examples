package org.com03.data;

import java.util.ArrayList;
import java.util.List;

import org.com02.domain.Employee;

public class DataSourceDev implements DataSource {
	
	public List<Employee> getEmployeeDetails() {
		@SuppressWarnings("rawtypes")
		List<Employee> empDetails = new ArrayList();
		Employee emp1 = new Employee(111, "Abc", 11000);
		Employee emp2 = new Employee(222, "Xyz", 22000);
		empDetails.add(emp1);
		empDetails.add(emp2);

		return empDetails;
	}
}
