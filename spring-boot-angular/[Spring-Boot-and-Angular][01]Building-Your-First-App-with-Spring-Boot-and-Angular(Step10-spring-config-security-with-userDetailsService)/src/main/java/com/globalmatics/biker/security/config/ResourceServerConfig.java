package com.globalmatics.biker.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * Resource Server – server hosting the protected resources, capable of accepting and responding to protected resource 
 * requests using access token
 * 
 * 		[2]: Like the Authorization Server, the convenient annotation @EnableResourceServer 
 * 			is used with a bean that extends ResourceServerConfigurerAdapter. 
 * 
 * 		[3]: The configure method shows how to setup resources for OAuth2 protection.
 * 
 * 		[4]: Spring Security’s expression based support is used here, i.e. #autho2.hasScope().
 * 			 An expression handler is registered by default by @EnableResourceServer.
 * @author knguyen97
 *
 */
@Configuration
@EnableResourceServer //[2]
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	 private static final String RESOURCE_ID = "my_rest_api";
    
    @Override // [3]
    public void configure(HttpSecurity http) throws Exception {
    	
        //http.authorizeRequests().antMatchers("/").permitAll();
        
    	  http
          .anonymous().disable()
          .authorizeRequests()
      	  .antMatchers("/h2/**").permitAll()
          .antMatchers("/api/v1/bikers/admin/**").hasRole("ADMIN")
          .antMatchers("/api/v1/bikers/**").hasAnyRole("ADMIN","USER")
          .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(RESOURCE_ID).stateless(false);
    }
}