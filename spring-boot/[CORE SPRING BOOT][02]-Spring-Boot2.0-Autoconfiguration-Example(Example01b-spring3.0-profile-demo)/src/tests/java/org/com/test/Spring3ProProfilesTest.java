package org.com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.com.config.DevEmployeeConfig;
import org.com.config.EmployeeConfig;
import org.com.config.ProdEmployeeConfig;
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
@ContextConfiguration(classes = { EmployeeConfig.class, DevEmployeeConfig.class,
		ProdEmployeeConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(value = "prod")
public class Spring3ProProfilesTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testProdDataSource() {
		EmployeeService service = (EmployeeService) applicationContext.getBean("employeeService");
		assertNotNull(service);
		List<Employee> employeeDetails = service.getEmployeeDetails();
		assertEquals(3, employeeDetails.size());
		assertEquals("Ramu", employeeDetails.get(0).getName());
		assertEquals("Charan", employeeDetails.get(1).getName());
		assertEquals("Joe", employeeDetails.get(2).getName());
	}
}
