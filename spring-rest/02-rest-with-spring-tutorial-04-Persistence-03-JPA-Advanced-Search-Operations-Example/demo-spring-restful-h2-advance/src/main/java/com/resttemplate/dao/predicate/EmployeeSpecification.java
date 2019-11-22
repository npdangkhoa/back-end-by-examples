package com.resttemplate.dao.predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.resttemplate.dto.SearchCriteria;
import com.resttemplate.entity.EmployeeEntity;

public class EmployeeSpecification implements Specification<EmployeeEntity> {

	private SearchCriteria criteria; 
	
	@Override
	public Predicate toPredicate(Root<EmployeeEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		switch (criteria.getOperation()) {
		case EQUALITY:
			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		case NEGATION:
			return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
		case GREATER_THAN:
			return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LESS_THAN:
			return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LIKE:
			return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
			
		case STARTS_WITH:
			return builder.like(root.get(criteria.getKey()), criteria.getValue().toString()+ "%");

		case ENDS_WITH:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue().toString());

		case CONTAINS:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue().toString() + "%");

		default:
			return null;
		}
		
		
	}

	public SearchCriteria getSearchDto() {
		return criteria;
	}

	public void setSearchDto(SearchCriteria searchDto) {
		this.criteria = searchDto;
	}

	public EmployeeSpecification(SearchCriteria searchDto) {
		super();
		this.criteria = searchDto;
	}
}
