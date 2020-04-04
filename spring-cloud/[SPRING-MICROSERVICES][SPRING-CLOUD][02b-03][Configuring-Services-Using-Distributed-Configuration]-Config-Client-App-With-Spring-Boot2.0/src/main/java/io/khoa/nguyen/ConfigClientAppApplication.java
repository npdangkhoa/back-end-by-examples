package io.khoa.nguyen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClientAppApplication {

	@Autowired
	private ConfigClientAppConfiguration config; 

	@Value("${some.other.property}")
	private String someOtherProperty;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAppApplication.class, args);
	}
	
	@RequestMapping("/")
	public String printConfig(){
		StringBuilder sb = new StringBuilder();
		sb.append("some.property = ");
		sb.append(config.getProperties());
		sb.append(" || ");
		sb.append("some.other.property = ");
		sb.append(someOtherProperty);
		
		return sb.toString();

	}
}
