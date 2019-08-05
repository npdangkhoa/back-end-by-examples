package com.resttemplate.hateoas.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.resttemplate.hateoas.event.ResourceCreatedEvent;

@Component
public class ResourceCreatedDiscoverabilityListener implements ApplicationListener<ResourceCreatedEvent>{

	@Override
	public void onApplicationEvent(ResourceCreatedEvent event) {
		addLinkHeaderOnResourceCreate(event.getResponse(), event.getIdOfNewResurce());
	}

	private void addLinkHeaderOnResourceCreate(HttpServletResponse response, long idOfNewResurce) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idOfNewResurce}").buildAndExpand(idOfNewResurce).toUri();
		response.setHeader(HttpHeaders.LOCATION, uri.toASCIIString());
	}
	


}
