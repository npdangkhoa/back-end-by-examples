package com.resttemplate.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
public class RootController {

	@GetMapping("/")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void adminRoot(final HttpServletRequest request, final HttpServletResponse response) {
	    String rootUri = request.getRequestURL().toString();
	 
	    URI fooUri = new UriTemplate("{rootUri}{resource}").expand(rootUri, "employees");
	    String linkToFoos = createLinkHeader(fooUri.toASCIIString(), "collection");
	    response.addHeader("Link", linkToFoos);
	}
	
	
    public String createLinkHeader(final String uri, final String rel) {
        return "<" + uri + ">; rel=\"" + rel + "\"";
    }

}
