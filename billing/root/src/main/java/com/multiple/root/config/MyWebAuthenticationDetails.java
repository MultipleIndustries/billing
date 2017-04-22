package com.multiple.root.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class MyWebAuthenticationDetails extends WebAuthenticationDetails {
	 private final String client;
	  public MyWebAuthenticationDetails(HttpServletRequest request) {
	    super(request);
	    this.client = request.getParameter("client");
	  }
	
	  public String getClient() {
		return client;
	}
	  
	  
}
