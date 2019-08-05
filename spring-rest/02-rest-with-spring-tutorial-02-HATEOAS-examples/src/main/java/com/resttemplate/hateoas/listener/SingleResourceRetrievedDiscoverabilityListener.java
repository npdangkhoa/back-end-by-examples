package com.resttemplate.hateoas.listener;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.resttemplate.hateoas.event.SingleResourceRetrievedEvent;

@Component 
public class SingleResourceRetrievedDiscoverabilityListener implements ApplicationListener<SingleResourceRetrievedEvent>{

	@Override
	public void onApplicationEvent(SingleResourceRetrievedEvent event) {
		addLinkHeaderOnSingleResourceRetrieval(event.getResponse());
	}

	private void addLinkHeaderOnSingleResourceRetrieval(HttpServletResponse response) {
		String requestUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri().toASCIIString();
		int lastIndexOf = requestUrl.lastIndexOf("/");
		String uriForCreateResource = requestUrl.substring(0, lastIndexOf);
		
		String linkHeader = createLinkHeader(uriForCreateResource, "collection");
		response.addHeader(HttpHeaders.LINK, linkHeader);
	}
	
    /**
     * Creates a Link Header to be stored in the {@link HttpServletResponse} to provide Discoverability features to the user
     * 
     * @param uri
     *            the base uri
     * @param rel
     *            the relative path
     * 
     * @return the complete url
     */
    public String createLinkHeader(final String uri, final String rel) {
        return "<" + uri + ">; rel=\"" + rel + "\"";
    }


}
