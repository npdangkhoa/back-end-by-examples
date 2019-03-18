package com.boraji.tutorial.spring00.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configurable
@ComponentScans(value = { @ComponentScan("com.boraji.tutorial.spring03.Service"),
						  @ComponentScan("com.boraji.tutorial.spring02.Dao") })
public class AppConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
		return factoryBean;
	}
}
