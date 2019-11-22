package com.resttemplate.unitTest;

import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.resttemplate.dao.IEmployeeDao;
import com.resttemplate.dto.SearchCriteria;
import com.resttemplate.entity.EmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class JPACriteriaQueryTest {
	
    @Autowired
    private IEmployeeDao employeeDao;
 
    private EmployeeEntity userJohn;
 
    private EmployeeEntity userTom;
 
    @Before
    @Transactional
    @Commit
    public void init() {
        userJohn = new EmployeeEntity();
        userJohn.setFirstName("John");
        userJohn.setLastName("Doe");
        userJohn.setEmail("john@doe.com");
        userJohn.setAge(22);
        employeeDao.save(userJohn);
 
        userTom = new EmployeeEntity();
        userTom.setFirstName("Tom");
        userTom.setLastName("Doe");
        userTom.setEmail("tom@doe.com");
        userTom.setAge(26);
        employeeDao.save(userTom);
    }
    
    @Test
    @Transactional
    public void givenPartialFirst_whenGettingListOfUsers_thenCorrect() {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("firstName", ":", "jo"));
     
        List<EmployeeEntity> results = employeeDao.searchEmployee(params);
     
        assertThat(userJohn, isIn(results));
        assertThat(userTom, not(isIn(results)));
    }
    
    @Test
    @Transactional
    public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("firstName", ":", "John"));
        params.add(new SearchCriteria("lastName", ":", "Doe"));
     
        List<EmployeeEntity> results = employeeDao.searchEmployee(params);     
    
        assertThat(userJohn, isIn(results));
        assertThat(userTom, not(isIn(results)));
    }
    
    
    @Test
    @Transactional
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("lastName", ":", "Doe"));
     
        List<EmployeeEntity> results = employeeDao.searchEmployee(params);
        assertThat(userJohn, isIn(results));
        assertThat(userTom, isIn(results));
    }
    
    @Test
    @Transactional
    public void givenLastAndAge_whenGettingListOfUsers_thenCorrect() {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("lastName", ":", "Doe"));
        params.add(new SearchCriteria("age", ">", "25"));
     
        List<EmployeeEntity> results = employeeDao.searchEmployee(params);
     
        assertThat(userTom, isIn(results));
        assertThat(userJohn, not(isIn(results)));
    }
    
    @Test
    @Transactional
    public void givenWrongFirstAndLast_whenGettingListOfUsers_thenCorrect() {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("firstName", ":", "Adam"));
        params.add(new SearchCriteria("lastName", ":", "Fox"));
     
        List<EmployeeEntity> results = employeeDao.searchEmployee(params);
        assertThat(userJohn, not(isIn(results)));
        assertThat(userTom, not(isIn(results)));
    }
    

}
