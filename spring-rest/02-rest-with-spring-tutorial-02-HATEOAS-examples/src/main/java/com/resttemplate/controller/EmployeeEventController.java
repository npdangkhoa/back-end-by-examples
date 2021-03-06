package com.resttemplate.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import com.resttemplate.dto.Employee;
import com.resttemplate.hateoas.event.ResourceCreatedEvent;
import com.resttemplate.hateoas.event.SingleResourceRetrievedEvent;

@RestController
@RequestMapping("event/employees")
public class EmployeeEventController {
	Map<Long, Employee> employeeMap = new HashMap<Long, Employee>();
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@PostConstruct
	public void initEmployees() {
		employeeMap.put(1L, new Employee(1L, "John"));
		employeeMap.put(2L, new Employee(2L, "Peter"));
		employeeMap.put(3L, new Employee(3L, "Mike"));
	}	

	
	@GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE)
	public Map<Long, Employee> getEmployees() {
		return employeeMap;
	}
	
	@RequestMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id, HttpServletResponse response) {
		Employee employee = employeeMap.get(id);
		
		// public event
		eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, response));
		return employee;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee employee, HttpServletResponse response) {
		employeeMap.put(employee.getId(), employee);
		
		//public event
		eventPublisher.publishEvent(new ResourceCreatedEvent(this, response, employee.getId()));
	}
	
	
	@PutMapping(value = "/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employeeMap.put(employee.getId(), employee);
		return employeeMap.get(employee.getId());
	}

	
}
