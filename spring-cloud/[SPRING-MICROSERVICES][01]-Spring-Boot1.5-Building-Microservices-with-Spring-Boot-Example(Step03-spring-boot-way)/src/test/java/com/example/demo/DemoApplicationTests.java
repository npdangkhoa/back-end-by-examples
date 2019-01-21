package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo01.config.DemoApplication;
import com.example.demo03.domain.Greet;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {DemoApplication.class})
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	RestTemplate temp = new RestTemplate();
	Greet greet = temp.getForObject("http://localhost:8080/", Greet.class);
	assertEquals("Hello World!", greet.getMessage());
	}

}
