package com.resttemplate.unitTest;

import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import com.resttemplate.dao.predicate.EmployeePredicateSpecification;
import com.resttemplate.dao.specification.EmployeeSpecificationRepository;
import com.resttemplate.dto.SearchDto;
import com.resttemplate.entity.EmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class JPASpecificationQueryTest {
		
    @Autowired
    private EmployeeSpecificationRepository employeeRepository;
 
    private EmployeeEntity userJohn;
 
    private EmployeeEntity userTom;
    
    
    @Before
    public void init() {
        userJohn = new EmployeeEntity();
        userJohn.setFirstName("John");
        userJohn.setLastName("Doe");
        userJohn.setEmail("john@doe.com");
        userJohn.setAge(22);
        employeeRepository.save(userJohn);
 
        userTom = new EmployeeEntity();
        userTom.setFirstName("Tom");
        userTom.setLastName("Doe");
        userTom.setEmail("tom@doe.com");
        userTom.setAge(26);
        employeeRepository.save(userTom);
    }
    
    @Test
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
    	List<EmployeeEntity> results = employeeRepository.findAll(new EmployeePredicateSpecification(new SearchDto("lastName", ":", "Doe")));
    	
    	assertThat(userJohn, isIn(results));
        assertThat(userTom, isIn(results));
    }
    
    @Test
    public void givenLastAndAge_whenGettingListOfUsers_thenCorrect() {
    	EmployeePredicateSpecification predicate01 = new EmployeePredicateSpecification(new SearchDto("age", ">", "25"));
    	EmployeePredicateSpecification predicate02 = new EmployeePredicateSpecification(new SearchDto("lastName", ":", "Doe"));
    	
    	List<EmployeeEntity> results = employeeRepository.findAll(Specification.where(predicate01).and(predicate02));
    	
		assertThat(userTom, isIn(results));
		assertThat(userJohn, not(isIn(results)));
    }
    
    @Test
    public void givenWrongFirstAndLast_whenGettingListOfUsers_thenCorrect() {
    	EmployeePredicateSpecification predicate01 = new EmployeePredicateSpecification(new SearchDto("firstName", ":", "Adam"));
    	EmployeePredicateSpecification predicate02 = new EmployeePredicateSpecification(new SearchDto("lastName", ":", "Fox"));
    	
    	List<EmployeeEntity> result = employeeRepository.findAll(Specification.where(predicate01).and(predicate02));
    	
    	assertThat(userTom, not(isIn(result)));
    	assertThat(userJohn, not(isIn(result)));
    }
    
    @Test
    public void givenPartialFirst_whenGettingListOfUsers_thenCorrect() {
    	EmployeePredicateSpecification predicate01 = new EmployeePredicateSpecification(new SearchDto("firstName", ":", "Jo"));
    	
    	List<EmployeeEntity> result = employeeRepository.findAll(predicate01);
    	
    	assertThat(userJohn, isIn(result));
    	assertThat(userTom, not(isIn(result)));
    }
}
