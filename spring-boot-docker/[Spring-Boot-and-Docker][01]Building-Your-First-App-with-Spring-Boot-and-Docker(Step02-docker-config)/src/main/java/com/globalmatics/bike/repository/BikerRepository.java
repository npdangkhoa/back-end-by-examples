package com.globalmatics.bike.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmatics.bike.models.Bike;

public interface BikerRepository extends JpaRepository<Bike, Long> {

}
