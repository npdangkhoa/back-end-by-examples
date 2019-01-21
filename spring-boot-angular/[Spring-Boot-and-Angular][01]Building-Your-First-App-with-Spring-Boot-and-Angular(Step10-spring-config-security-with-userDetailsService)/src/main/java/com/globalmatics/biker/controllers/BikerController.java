package com.globalmatics.biker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globalmatics.biker.models.Biker;
import com.globalmatics.biker.repository.BikerRepository;

@RestController
@RequestMapping("/api/v1/bikers")
public class BikerController {
	
	@Autowired
	private BikerRepository repository;

	@GetMapping("/admin")
	public List<Biker> list() {
		return repository.findAll();
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Biker bike) {
		repository.save(bike);
		
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("#name == authentication.name or authentication.name == 'admin'")
	public Biker get(@PathVariable("id") long id) throws InterruptedException {
		Optional<Biker> findById = repository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return new Biker();
	}
}
