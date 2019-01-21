package com.org.spring.reactor06.junitTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.org.spring.reactor05.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class loadData {
	private final Logger LOG = org.slf4j.LoggerFactory.getLogger(loadData.class);

	
	@Test
	public void exampleTest() {
		LOG.info("As you can see, as soon as the endpoint hit, all 10 tasks get submitted instantly without creating any blocking. "
				+ "And once submitted, the notification events get processed in parallel.\r\n" 
				+ "\r\n Keep in mind that in our scenario there’s no need to process these events in any order.");
		RestTemplate rest = new RestTemplate();
		rest.getForObject ("http://localhost:8080/startNotification/10", String.class);
	}
}
