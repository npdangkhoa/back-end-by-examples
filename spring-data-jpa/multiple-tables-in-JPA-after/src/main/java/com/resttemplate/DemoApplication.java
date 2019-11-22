package com.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
//	@Bean
//	public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
//		return new ShallowEtagHeaderFilter();
//	}
	
	@Bean
	public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter(){
		FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean = 
				new FilterRegistrationBean<>(new ShallowEtagHeaderFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setName("etagFilter");
		
		return filterRegistrationBean;
	}

}
