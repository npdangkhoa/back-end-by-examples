package com.resttemplate.dao.predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.resttemplate.dto.SearchDto;
import com.resttemplate.entity.EmployeeEntity;

public class EmployeePredicateSpecification implements Specification<EmployeeEntity> {

	private SearchDto searchDto; 
	
	@Override
	public Predicate toPredicate(Root<EmployeeEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if(searchDto.getOperation().equalsIgnoreCase(">")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get(searchDto.getKey()), searchDto.getValue().toString());
			
		} else if (searchDto.getOperation().equalsIgnoreCase("<")) {
			return criteriaBuilder.lessThanOrEqualTo(root.get(searchDto.getKey()), searchDto.getValue().toString());
			
		} else if (searchDto.getOperation().equalsIgnoreCase(":")) {
			if (root.get(searchDto.getKey()).getJavaType() == String.class) {
				return criteriaBuilder.like(root.get(searchDto.getKey()), "%" +searchDto.getValue()+ "%");
			} else {
				return criteriaBuilder.equal(root.get(searchDto.getKey()), searchDto.getValue().toString());
			}
		}
		return null;
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public EmployeePredicateSpecification(SearchDto searchDto) {
		super();
		this.searchDto = searchDto;
	}

	
	
}
