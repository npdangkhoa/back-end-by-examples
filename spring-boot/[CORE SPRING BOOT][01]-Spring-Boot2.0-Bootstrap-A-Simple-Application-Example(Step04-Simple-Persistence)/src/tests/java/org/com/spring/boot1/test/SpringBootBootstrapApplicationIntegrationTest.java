package org.com.spring.boot1.test;

import org.com.spring.boot01.config.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootBootstrapApplicationIntegrationTest {

	@Test
	public void contextLoads() {
	}

}
