package com.resttemplate.dao;

import java.util.List;

import com.resttemplate.dto.SearchCriteria;
import com.resttemplate.entity.EmployeeEntity;

public interface IEmployeeDao {
	public List<EmployeeEntity> searchEmployee(List<SearchCriteria> params);
	public void save(EmployeeEntity entity);
}
