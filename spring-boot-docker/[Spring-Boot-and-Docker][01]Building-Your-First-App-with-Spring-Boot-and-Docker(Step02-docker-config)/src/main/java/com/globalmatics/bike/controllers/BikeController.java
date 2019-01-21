package com.globalmatics.bike.controllers;

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

import com.globalmatics.bike.models.Bike;
import com.globalmatics.bike.repository.BikerRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {
	
	@Autowired
	private BikerRepository repository;

	@GetMapping
	public List<Bike> list() {
		return repository.findAll();
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		repository.save(bike);
		
	}
	
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id) throws InterruptedException {
		Optional<Bike> findById = repository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return new Bike();
	}
}
