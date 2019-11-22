package com.resttemplate.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.resttemplate.dao.predicate.EmployeeSpecification;
import com.resttemplate.dto.SearchCriteria;
import com.resttemplate.entity.EmployeeEntity;
import com.resttemplate.utils.SearchOperation;

public class EmployeeSpecificationsBuilder {
	private List<SearchCriteria> params;
	
	public EmployeeSpecificationsBuilder with(String key, String operation, Object value, String prefix, String suffix) {
		SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
		if (op != null) {
			if(op == SearchOperation.EQUALITY) {
				boolean startWithAsterisk = prefix.contains("*");
				boolean endWithAsterisk = suffix.contains("*");
				
				if (startWithAsterisk && endWithAsterisk) {
					op = SearchOperation.CONTAINS;
				} else if (startWithAsterisk) {
					op = SearchOperation.ENDS_WITH;
				} else if (endWithAsterisk){
					 op = SearchOperation.STARTS_WITH;
				}
			}
			if (params == null) {
				params = new ArrayList<>();
			}
			params.add(new SearchCriteria(key, op, value));
		}
		return this;
	}
	
	public Specification<EmployeeEntity> build(){
		if (params.size() == 0) {
			return null;			
		} 
		
		Specification result = new EmployeeSpecification(params.get(0));
		for (int i = 0; i < params.size(); i++) {
			result = params.get(i).isOrPredicate()
					? Specification.where(result).or(new EmployeeSpecification(params.get(i)))
							: Specification.where(result).and(new EmployeeSpecification(params.get(i)));
		}
		
		return result;
	}
}
