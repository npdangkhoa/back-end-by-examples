package com.boraji.tutorial.spring04.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.spring01.entities.Company;
import com.boraji.tutorial.spring01.entities.CompanyType;
import com.boraji.tutorial.spring03.repository.CompanyJpaRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyJpaRepository companyJpaRepository;
	
    public List<Company> searchByNameAndType(String companyName, CompanyType type) {
    	
    	List<Company> result = companyJpaRepository.findAll(new Specification<Company>() {
			
			@Override
			public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate preType = cb.equal(root.<Company>get("type"), type);
				Predicate preName = cb.equal(root.<Company>get("name"), companyName);

				Predicate result = cb.and(preType, preName);
				
				return result;
			}
		});
    	
    	
    	return result;
    }
    
    
    
    public Company save(Company company) {
        return companyJpaRepository.save(company);
    }
     
    public void delete(Company company){
    	companyJpaRepository.delete(company);
    }
    
}
