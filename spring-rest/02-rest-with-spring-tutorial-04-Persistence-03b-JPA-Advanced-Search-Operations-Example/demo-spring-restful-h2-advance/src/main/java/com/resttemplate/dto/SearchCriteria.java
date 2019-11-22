package com.resttemplate.dto;

import com.resttemplate.utils.SearchOperation;

public class SearchCriteria {
	private String key;
	private SearchOperation operation;
	private Object value;
	private boolean orPredicate;
	
	public SearchCriteria(String key, SearchOperation operation, Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public SearchOperation getOperation() {
		return operation;
	}
	public void setOperation(SearchOperation operation) {
		this.operation = operation;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the orPredicate
	 */
	public boolean isOrPredicate() {
		return orPredicate;
	}

	/**
	 * @param orPredicate the orPredicate to set
	 */
	public void setOrPredicate(boolean orPredicate) {
		this.orPredicate = orPredicate;
	}
	
}
