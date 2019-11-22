package com.resttemplate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.resttemplate.dto.SearchCriteria;
import com.resttemplate.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<EmployeeEntity> searchEmployee(List<SearchCriteria> params) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> query = builder.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
		
		Predicate predicate = builder.conjunction();
		SearchQueryCriteriaEmployee searchConsumer = new SearchQueryCriteriaEmployee(predicate, builder, root);
		
		params.stream().forEach(searchConsumer);
		predicate = searchConsumer.getPredicate();
		query.where(predicate);
		
		List<EmployeeEntity> resultList = entityManager.createQuery(query).getResultList();
		return resultList;		
	}

	@Override
	public void save(EmployeeEntity entity) {
		entityManager.persist(entity);
	}
	
	
}
