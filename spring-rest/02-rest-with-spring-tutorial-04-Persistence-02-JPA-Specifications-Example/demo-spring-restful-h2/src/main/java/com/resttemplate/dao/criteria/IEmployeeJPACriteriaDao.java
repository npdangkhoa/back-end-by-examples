package com.resttemplate.dao.criteria;

import java.util.List;

import com.resttemplate.dto.SearchDto;
import com.resttemplate.entity.EmployeeEntity;

public interface IEmployeeJPACriteriaDao {
	public List<EmployeeEntity> searchEmployeeJPACriteria(List<SearchDto> params);
	public void save(EmployeeEntity entity);
}
