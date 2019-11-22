package com.resttemplate.unitTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.collection.IsIn.isIn;
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
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringRunner;

import com.resttemplate.dao.predicate.EmployeeSpecification;
import com.resttemplate.dao.specification.EmployeeSpecificationRepository;
import com.resttemplate.dto.SearchCriteria;
import com.resttemplate.entity.EmployeeEntity;
import com.resttemplate.utils.SearchOperation;

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
    public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
    	SearchCriteria firstNameCriteria = new SearchCriteria("firstName", SearchOperation.EQUALITY, "John");
    	SearchCriteria lastNameCriteria = new SearchCriteria("lastName", SearchOperation.EQUALITY, "Doe");
    	
    	EmployeeSpecification firstNameSpecification = new EmployeeSpecification(firstNameCriteria);
    	EmployeeSpecification lastNameSpecification = new EmployeeSpecification(lastNameCriteria);
    	
    	
    	List<EmployeeEntity> result = employeeRepository.findAll(Specification.where(firstNameSpecification).and(lastNameSpecification));
    	
    	assertThat(userJohn, isIn(result));
   	
    }
    
    @Test
    public void givenFirstNameInverse_whenGettingListOfUsers_thenCorrect() {
    	SearchCriteria searchCriteria = new SearchCriteria("firstName", SearchOperation.NEGATION, "John");
    	List<EmployeeEntity> list = employeeRepository.findAll(Specification.where(new EmployeeSpecification(searchCriteria)));
    	assertThat(userTom, isIn(list));
    }
    
    @Test
    public void givenMinAge_whenGettingListOfUsers_thenCorrect() {
    	SearchCriteria criteria = new SearchCriteria("age", SearchOperation.GREATER_THAN, "25");
    	List<EmployeeEntity> list = employeeRepository.findAll(Specification.where(new EmployeeSpecification(criteria)));
    	assertThat(userTom, isIn(list));

    }
    
    @Test
    public void givenFirstNamePrefix_whenGettingListOfUsers_thenCorrect() {
    	EmployeeSpecification specification = new EmployeeSpecification(new SearchCriteria("firstName", SearchOperation.STARTS_WITH, "Jo"));
    	List<EmployeeEntity> list = employeeRepository.findAll(Specification.where(specification));
    	assertThat(userJohn, isIn(list));
    }
    
    @Test
    public void givenFirstNameSuffix_whenGettingListOfUsers_thenCorrect() {
	    EmployeeSpecification specification = new EmployeeSpecification(new SearchCriteria("firstName", SearchOperation.ENDS_WITH, "n"));
	    List<EmployeeEntity> list = employeeRepository.findAll(Specification.where(specification));
		assertThat(userJohn, isIn(list));
    }
    
    @Test
    public void givenFirstNameSubstring_whenGettingListOfUsers_thenCorrect() {
    	EmployeeSpecification specification = new EmployeeSpecification(new SearchCriteria("firstName", SearchOperation.CONTAINS, "oh"));
    	List<EmployeeEntity> list = employeeRepository.findAll(Specification.where(specification));
		assertThat(userJohn, isIn(list));

    }
    
    @Test
    public void givenAgeRange_whenGettingListOfUsers_thenCorrect() {
    	EmployeeSpecification spec01 = new EmployeeSpecification(new SearchCriteria("age", SearchOperation.GREATER_THAN, "20"));
    	EmployeeSpecification spec02 = new EmployeeSpecification(new SearchCriteria("age", SearchOperation.LESS_THAN, "25"));
    	
    	List<EmployeeEntity> list = employeeRepository.findAll(Specification.where(spec01).and(spec02));
		assertThat(userJohn, isIn(list));

    }
    
    
}
