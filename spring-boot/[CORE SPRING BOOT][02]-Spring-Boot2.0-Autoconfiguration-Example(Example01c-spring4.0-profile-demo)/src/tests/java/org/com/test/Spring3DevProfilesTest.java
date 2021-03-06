package org.com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.com.config.EmployeeConfig;
import org.com.config.EmployeeDataSourceConfig;
import org.com02.domain.Employee;
import org.com05.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EmployeeConfig.class, 
								  EmployeeDataSourceConfig.class
								}, 
						loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(value = "dev")
public class Spring3DevProfilesTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testDevDataSource() {
		EmployeeService service = (EmployeeService) applicationContext.getBean("employeeService");
		assertNotNull(service);
		List<Employee> employeeDetails = service.getEmployeeDetails();
		assertEquals(2, employeeDetails.size());
		assertEquals("Abc", employeeDetails.get(0).getName());
		assertEquals("Xyz", employeeDetails.get(1).getName());
	}
}
