package com.boraji.tutorial.spring03.repository;


import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring01.entities.Company;
import com.boraji.tutorial.spring01.entities.CompanyType;

@Repository
public interface CompanyJpaRepository extends JpaRepository<Company, Long> {
	
	   @Query("SELECT req FROM Company req  WHERE req.type=(:type) AND req.name= (:name)")
	    List<Company> findByTypeAndName(@Param("type") CompanyType type, @Param("name") String name);
	 
	    List<Company> findAll(Specification<Company> specification);
}
