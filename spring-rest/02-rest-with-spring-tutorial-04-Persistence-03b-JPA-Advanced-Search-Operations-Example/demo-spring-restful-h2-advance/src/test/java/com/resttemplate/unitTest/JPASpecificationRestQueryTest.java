package com.resttemplate.unitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.resttemplate.dao.specification.EmployeeSpecificationRepository;
import com.resttemplate.entity.EmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JPASpecificationRestQueryTest {
	
	@Autowired
	private EmployeeSpecificationRepository employeeSpecificationRepository;
	
	@LocalServerPort
	int port;
	
    private EmployeeEntity userJohn;
    
    private EmployeeEntity userTom;
    
	@Before
	public void init() {
        userJohn = new EmployeeEntity();
        userJohn.setFirstName("John");
        userJohn.setLastName("Doe");
        userJohn.setEmail("john@doe.com");
        userJohn.setAge(22);
        employeeSpecificationRepository.save(userJohn);
 
        userTom = new EmployeeEntity();
        userTom.setFirstName("Tom");
        userTom.setLastName("Doe");
        userTom.setEmail("tom@doe.com");
        userTom.setAge(26);
        employeeSpecificationRepository.save(userTom);
        
        RestAssured.port  = port;
	}
	
	private RequestSpecification giveAuthen() {
		return RestAssured.given().auth()
								.preemptive()
								.basic("userName", "password");
	}
	
	@Test
	public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
		Response response = giveAuthen().basePath("/employees/specification")
				.param("search", "firstName:John,lastName:Doe")
				.get();
		String result = response.body().asString();
		assertTrue(result.contains(userJohn.getEmail()));
		assertFalse(result.contains(userTom.getEmail()));
	}
}
