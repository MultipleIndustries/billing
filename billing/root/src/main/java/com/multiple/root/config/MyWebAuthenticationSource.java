package com.multiple.root.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;

public class MyWebAuthenticationSource implements AuthenticationDetailsSource<HttpServletRequest, MyWebAuthenticationDetails>  {

	 public MyWebAuthenticationDetails buildDetails(HttpServletRequest context){
		 return new MyWebAuthenticationDetails(context);
	 }
}
