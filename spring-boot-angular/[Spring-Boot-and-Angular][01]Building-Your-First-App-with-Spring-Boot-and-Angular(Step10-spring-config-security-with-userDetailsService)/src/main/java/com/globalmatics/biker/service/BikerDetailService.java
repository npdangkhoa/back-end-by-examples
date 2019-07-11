package com.globalmatics.biker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.globalmatics.biker.models.Biker;
import com.globalmatics.biker.repository.BikerRepository;

@Service(value="bikerDetailService")
public class BikerDetailService  implements UserDetailsService {

	@Autowired
	private BikerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("===================================UserName login into System: " + userName);

		Optional<Biker> bike = repository.findByName(userName);
		
		if(bike.get() == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(bike.get().getName());
			builder.password(new BCryptPasswordEncoder().encode(bike.get().getPassword()));
			builder.roles(bike.get().getRole().split(","));	
			
			System.out.println("===================================UserName login into System: " + userName);
			System.out.println("===================================password login into System: " + bike.get().getPassword());
			System.out.println("===================================Role login into System: " + bike.get().getRole().split(","));


			return builder.build();
	}

}
