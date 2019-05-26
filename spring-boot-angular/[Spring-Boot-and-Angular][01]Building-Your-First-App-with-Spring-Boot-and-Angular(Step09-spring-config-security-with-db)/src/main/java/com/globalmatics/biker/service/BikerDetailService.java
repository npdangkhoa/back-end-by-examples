package com.globalmatics.biker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.globalmatics.biker.repository.BikerRepository;

@Service(value="bikerDetailService")
public class BikerDetailService  implements UserDetailsService {

	@Autowired
	private BikerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {

		//Optional<Biker> bike = repository.findById(Long.valueOf(arg0));
		
//		if(bike.get() == null){
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
		UserBuilder builder ;
		
		System.out.println("==================================="+ arg0);
		if ("my-trusted-client".equals(arg0)) {
			builder = org.springframework.security.core.userdetails.User.withUsername("my-trusted-client");
			builder.password(new BCryptPasswordEncoder().encode("secret"));
			builder.roles("ADMIN", "USER");	
			return builder.build();

		}
		if ("bill".equals(arg0)) {
			builder = org.springframework.security.core.userdetails.User.withUsername("bill");
			builder.password(new BCryptPasswordEncoder().encode("abc123"));
			builder.roles("ADMIN", "USER");	
			return builder.build();

		}
		
		
		return null;
	}

}
