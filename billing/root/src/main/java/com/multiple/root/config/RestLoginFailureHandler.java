package com.multiple.root.config;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component(value="restAuthenticationFailureHandler")
public class RestLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
	public void onAuthenticationFailure(HttpServletRequest request,	HttpServletResponse response, AuthenticationException exception)
	throws IOException, ServletException {

	// TODO Write response containing failure message

	}
}
