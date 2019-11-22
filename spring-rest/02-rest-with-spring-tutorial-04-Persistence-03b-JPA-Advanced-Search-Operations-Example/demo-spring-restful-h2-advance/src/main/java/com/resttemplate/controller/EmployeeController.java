package com.resttemplate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Joiner;
import com.resttemplate.builder.EmployeeSpecificationsBuilder;
import com.resttemplate.dao.specification.EmployeeSpecificationRepository;
import com.resttemplate.dto.Employee;
import com.resttemplate.entity.EmployeeEntity;
import com.resttemplate.utils.SearchOperation;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	Map<Long, Employee> employeeMap = new HashMap();
	
	@Autowired
	private EmployeeSpecificationRepository repository;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/specification")
	@ResponseBody
	public List<EmployeeEntity> findAllBySpecification(@RequestParam(value="search") String search){
		EmployeeSpecificationsBuilder builder = new EmployeeSpecificationsBuilder();
		String join = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
		
	    Pattern pattern = Pattern.compile("(\\w+?)(" + join + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
	    Matcher matcher = pattern.matcher(search + ",");
	    while (matcher.find()) {
	    	builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
		}
	    
	    Specification<EmployeeEntity> specification = builder.build();
	    return repository.findAll(specification);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	@ResponseBody
	public List<EmployeeEntity> findAll(){
	    return repository.findAll();
	}
}
