package spring.boot.hero;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder().username("user").password("password").authorities("USER_ROLE").build(),
				User.withDefaultPasswordEncoder().username("admin").password("admin").authorities("ROLE_ACTUATOR", "ROLE_USER", "ROLE_ADMIN").build()
				);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.requestMatchers(EndpointRequest.to("info")).permitAll()
				.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/**").permitAll()
			.and().httpBasic();

		http.csrf().ignoringAntMatchers("/h2-console/**");
		http.headers().frameOptions().disable();
        
		super.configure(http);
	}
	
	
	
}
