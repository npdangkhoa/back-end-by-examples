package com.resttemplate.dao.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.resttemplate.dao.predicate.EmployeePredicateCriteria;
import com.resttemplate.dto.SearchDto;
import com.resttemplate.entity.EmployeeEntity;

@Repository
public class EmployeeDaoJPACriteriaImpl implements IEmployeeJPACriteriaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<EmployeeEntity> searchEmployeeJPACriteria(List<SearchDto> params) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> query = builder.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
		
		Predicate predicate = builder.conjunction();
		EmployeePredicateCriteria searchConsumer = new EmployeePredicateCriteria(predicate, builder, root);
		
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
