package com.globalmatics.biker.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.globalmatics.biker.models.Biker;
import com.globalmatics.biker.repository.BikerRepository;

@Service(value="bikerDetailService")
public class BikerDetailService  implements UserDetailsService {

	@Autowired
	private BikerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {

		Optional<Biker> bike = repository.findById(Long.valueOf(arg0));
		
		if(bike.get() == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(bike.get().getName(), "password", getAuthority());		
	}

	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
