package org.com03.data;

import java.util.ArrayList;
import java.util.List;

import org.com02.domain.Employee;

public class DataSourcePro implements DataSource {
	
	public List<Employee> getEmployeeDetails() {
		List<Employee> empDetails = new ArrayList<Employee>();
		Employee emp1 = new Employee(9001, "Ramu", 45000);
		Employee emp2 = new Employee(9002, "Charan", 35000);
		Employee emp3 = new Employee(9003, "Joe", 55000);
		empDetails.add(emp1);
		empDetails.add(emp2);
		empDetails.add(emp3);

		return empDetails;
	}
}
