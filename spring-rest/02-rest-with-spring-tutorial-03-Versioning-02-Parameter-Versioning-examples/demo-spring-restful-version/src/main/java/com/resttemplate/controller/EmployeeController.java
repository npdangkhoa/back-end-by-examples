package com.resttemplate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resttemplate.v1.dto.Employee;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {
	Map<Long, Employee> employeeMapV1 = new HashMap();
	Map<Long, com.resttemplate.v2.dto.Employee> employeeMapV2 = new HashMap();

	@PostConstruct
	public void initEmployees() {
		employeeMapV1.put(1L, new Employee(1L, "John"));
		employeeMapV1.put(2L, new Employee(2L, "Peter"));
		employeeMapV1.put(3L, new Employee(3L, "Mike"));
		
		employeeMapV2.put(1L, new com.resttemplate.v2.dto.Employee(1L, "John", "Nguyen"));
		employeeMapV2.put(2L, new com.resttemplate.v2.dto.Employee(2L, "Peter", "Phan"));
		employeeMapV2.put(3L, new com.resttemplate.v2.dto.Employee(3L, "Mike", "San"));
	}
	
	@GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE, params="version=1")
	public Map<Long, Employee> getEmployees() {
		return employeeMapV1;
	}
	
	@RequestMapping(value = "/{id}", params="version=1")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return employeeMapV1.get(id);
	}
	
	@PostMapping(value = "/{id}", params="version=1")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employeeMapV1.put(employee.getId(), employee);
		return employeeMapV1.get(employee.getId());
	}
	
	@GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE, params="version=2")
	public Map<Long, com.resttemplate.v2.dto.Employee> getEmployeesV2() {
		return employeeMapV2;
	}
	
	@RequestMapping(value = "/{id}", params="version=2")
	public com.resttemplate.v2.dto.Employee getEmployeeV2(@PathVariable("id") Long id) {
		return employeeMapV2.get(id);
	}
	
	@PostMapping(value = "/{id}", params="version=2")
	public com.resttemplate.v2.dto.Employee updateEmployeeV2(@PathVariable("id") Long id, @RequestBody com.resttemplate.v2.dto.Employee employee) {
		employeeMapV2.put(employee.getId(), employee);
		return employeeMapV2.get(employee.getId());
	}
}
