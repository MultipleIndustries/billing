package com.multiple.root.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.model.Role;
import com.multiple.common.model.User;
import com.multiple.common.service.UserService;
import com.multiple.kernel.exception.CustomException;

@Component(value="customAuthenticationEntryPoint")
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("authManager")
	protected AuthenticationManager authenticationManager;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String loginId=request.getParameter("mobileNo");
		String successUrl="/Index";
		String url = request.getContextPath();
		String password = request.getParameter("otp");
		boolean responseCommited = false;
			
		try {
			User user = userService.findByMobile(loginId);
			if(user != null && password != null && password.equals("1234")){
				authenticateUserAndSetSession(user, request);
			} else {
				throw new BadCredentialsException("");
			}
		} 
		catch (BadCredentialsException e) {
			response.sendRedirect(url+"/VerifyOtp?error="+CustomException.AUTHENTICATION_FAILURE.getCode());
			responseCommited = true;
		}
		catch (NoSuchUserException e) {
			response.sendRedirect(url+"?errorCode="+CustomException.AUTHENTICATION_FAILURE.getCode());
			responseCommited = true;
		}
		
		if(!responseCommited){
			request.getRequestDispatcher(successUrl).forward(request, response);
		}
			
	}

	 private void authenticateUserAndSetSession(User user,
			 HttpServletRequest request)
			 {
			 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
			 user.getUsername(), user.getPassword());

			 // generate session if one doesn't exist
			 request.getSession();

			 token.setDetails(new WebAuthenticationDetails(request));
			 Authentication authenticatedUser = authenticationManager.authenticate(token);
			 ((User)authenticatedUser.getPrincipal()).setMacId(user.getMacId());
			 SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
}
