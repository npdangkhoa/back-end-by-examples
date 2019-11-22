package com.resttemplate.dao;

import java.util.function.Consumer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.resttemplate.dto.SearchCriteria;
import com.resttemplate.entity.EmployeeEntity;

public class SearchQueryCriteriaEmployee implements Consumer<SearchCriteria> {

	private Predicate predicate;
	private CriteriaBuilder builder;
	private Root<EmployeeEntity> root;
	
	public SearchQueryCriteriaEmployee(Predicate predicate, CriteriaBuilder builder, Root<EmployeeEntity> root) {
		this.predicate = predicate;
		this.builder = builder;
		this.root = root;
	}

	@Override
	public void accept(SearchCriteria param) {
		
		if(param.getOperation().equalsIgnoreCase(">")) {
			predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get(param.getKey()), 
					param.getValue().toString()));
			
		} else if (param.getOperation().equalsIgnoreCase("<")) {
			predicate = builder.and(predicate, builder.lessThan(root.get(param.getKey()), 
					param.getValue().toString()));
			
		} else if (param.getOperation().equalsIgnoreCase(":")) {
			if (root.get(param.getKey()).getJavaType() == String.class) {
				predicate = builder.and(predicate, builder.like(root.get(param.getKey()), "%"+param.getValue().toString()+"%"));
				
			} else {
				predicate = builder.and(predicate, builder.equal(root.get(param.getKey()), param.getValue().toString()));
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
