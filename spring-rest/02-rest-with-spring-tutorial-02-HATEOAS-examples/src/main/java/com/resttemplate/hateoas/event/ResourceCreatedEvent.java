package com.resttemplate.hateoas.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class ResourceCreatedEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6839213502619465233L;
	
	private long idOfNewResurce;
	private HttpServletResponse response;
	
	public ResourceCreatedEvent(Object source, HttpServletResponse response, final long idOfNewResource) {
		super(source);
		this.response = response;
		this.idOfNewResurce = idOfNewResource;
	}

	public long getIdOfNewResurce() {
		return idOfNewResurce;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

}
