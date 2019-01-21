package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo01.config.DemoApplication;
import com.example.demo03.domain.Greet;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SecureBasicServiceTests {

	private String url = "http://localhost:8080/greet/";

	@Test
	public void testSecureService() {
		String plainCreds = "admin:admin";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + new String(Base64.encode(plainCreds.getBytes())));
		HttpEntity<String> request = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Greet> response = restTemplate.exchange(url, HttpMethod.GET, request, Greet.class);
		Assert.assertEquals("Hello World!", response.getBody().getMessage());
	}
}
