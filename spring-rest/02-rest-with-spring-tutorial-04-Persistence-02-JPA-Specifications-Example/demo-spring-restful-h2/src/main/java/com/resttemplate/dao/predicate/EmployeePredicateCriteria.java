package com.resttemplate.dao.predicate;

import java.util.function.Consumer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.resttemplate.dto.SearchDto;
import com.resttemplate.entity.EmployeeEntity;

public class EmployeePredicateCriteria implements Consumer<SearchDto> {

	private Predicate predicate;
	private CriteriaBuilder builder;
	private Root<EmployeeEntity> root;
	
	public EmployeePredicateCriteria(Predicate predicate, CriteriaBuilder builder, Root<EmployeeEntity> root) {
		this.predicate = predicate;
		this.builder = builder;
		this.root = root;
	}

	@Override
	public void accept(SearchDto searchDto) {
		
		if(searchDto.getOperation().equalsIgnoreCase(">")) {
			predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get(searchDto.getKey()), 
					searchDto.getValue().toString()));
			
		} else if (searchDto.getOperation().equalsIgnoreCase("<")) {
			predicate = builder.and(predicate, builder.lessThan(root.get(searchDto.getKey()), 
					searchDto.getValue().toString()));
			
		} else if (searchDto.getOperation().equalsIgnoreCase(":")) {
			if (root.get(searchDto.getKey()).getJavaType() == String.class) {
				predicate = builder.and(predicate, builder.like(root.get(searchDto.getKey()), "%"+searchDto.getValue().toString()+"%"));
				
			} else {
				predicate = builder.and(predicate, builder.equal(root.get(searchDto.getKey()), searchDto.getValue().toString()));
			}
		}
	}

	

	public Predicate getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	public CriteriaBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(CriteriaBuilder builder) {
		this.builder = builder;
	}

	public Root<EmployeeEntity> getRoot() {
		return root;
	}

	public void setRoot(Root<EmployeeEntity> root) {
		this.root = root;
	}

	
	
}
