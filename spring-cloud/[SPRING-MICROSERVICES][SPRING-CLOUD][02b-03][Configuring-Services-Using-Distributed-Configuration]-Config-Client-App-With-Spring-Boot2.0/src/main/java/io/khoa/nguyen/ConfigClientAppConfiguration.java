package io.khoa.nguyen;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="some")
public class ConfigClientAppConfiguration {
	
	//BUG: properties is the field of ConfigClientAppConfiguration. must following file config-client-app.property
	// some.properties=profile specific value
	private String properties;

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}
	
	

}
