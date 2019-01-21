package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo01.config.DemoApplication;
import com.example.demo03.domain.Greet;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SecureServiceOAuth2Tests {

	@Test
	public void testOAuthService() {
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setUsername("admin");
		resource.setPassword("admin");
		resource.setAccessTokenUri("http://localhost:8080/oauth/token");
		resource.setClientId("trustedclient");
		resource.setClientSecret("trustedclient123");
		resource.setGrantType("password");
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, clientContext);
		Greet greet = restTemplate.getForObject("http://localhost:8080/greet", Greet.class);
		org.junit.Assert.assertEquals("Hello dev", greet.getMessage());
	}
}
