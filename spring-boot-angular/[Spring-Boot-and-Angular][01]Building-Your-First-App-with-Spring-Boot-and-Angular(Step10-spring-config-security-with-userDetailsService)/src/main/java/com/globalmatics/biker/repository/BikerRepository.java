package com.globalmatics.biker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmatics.biker.models.Biker;

public interface BikerRepository extends JpaRepository<Biker, Long> {
	
	public Optional<Biker> findByName(String name);
}

