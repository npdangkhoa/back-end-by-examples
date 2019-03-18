package com.boraji.tutorial.spring00.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configurable
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.boraji.tutorial.spring03.Service"),
						  @ComponentScan("com.boraji.tutorial.spring02.Dao") })
public class AppConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
		return factoryBean;
	}
	
	//	/Exception in thread "main" javax.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call
	@Bean
	public JpaTransactionManager getJpaTransactionManager() {
		JpaTransactionManager transaction = new JpaTransactionManager();
		transaction.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return transaction;
	}
}
