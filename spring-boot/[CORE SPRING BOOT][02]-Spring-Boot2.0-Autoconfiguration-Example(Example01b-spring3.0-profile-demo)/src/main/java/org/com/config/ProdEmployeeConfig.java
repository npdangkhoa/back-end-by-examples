package org.com.config;

import org.com03.data.DataSource;
import org.com03.data.DataSourceDev;
import org.com03.data.DataSourcePro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdEmployeeConfig {

	@Bean
	public DataSource dataSource() {
		return new DataSourcePro();
	}
}
