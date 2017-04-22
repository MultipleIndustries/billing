package com.multiple.root.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.model.User;
import com.multiple.common.service.UserService;
import com.multiple.kernel.exception.CustomException;

@CrossOrigin
@Component(value="restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("authManager")
	protected AuthenticationManager authenticationManager;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String userName="";
		String password="";
		String url="";
		String macId = null;
		boolean isAddMember = false;
		if (ServletFileUpload.isMultipartContent(request)) {
			
			List<FileItem> items = null;
			try {
				items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			for (FileItem item : items) {

				if (item.isFormField()) {
					if(item.getFieldName().equalsIgnoreCase("userName"))
					{
						userName=item.getString();
					}
					if(item.getFieldName().equalsIgnoreCase("password"))
					{
						password=item.getString();
					}
					if(item.getFieldName().equalsIgnoreCase("url"))
					{
						url=item.getString();
					}
					if(item.getFieldName().equalsIgnoreCase("macId"))
					{
						macId=item.getString();
					}
					if(item.getFieldName().equalsIgnoreCase("isAddMember")){
						isAddMember = Boolean.valueOf(item.getString());
					}
				}
			}
			request.setAttribute("parts", items);
		}
		else{
		 userName= request.getParameter("userName");
		 password= request.getParameter("password");
		 url= request.getParameter("url");
		 macId= request.getParameter("macId");
		}
		try {
			User user = userService.findByMobile(userName);
			if(user != null){
				user.setMacId(macId);
				user.setPassword(password!=null?password:"");
				authenticateUserAndSetSession(user, request);
				request.getRequestDispatcher(url).forward(request, response);
			}else if(user == null && isAddMember){
				System.out.println("Member registration via android client...");
			}else{
				response.getWriter().println("errorCode="+CustomException.AUTHENTICATION_FAILURE.getCode());
			}
			
		} catch (NoSuchUserException e) {
			response.getWriter().println("errorCode="+CustomException.AUTHENTICATION_FAILURE.getCode());
		}catch (BadCredentialsException e) {
			response.getWriter().println("errorCode="+CustomException.AUTHENTICATION_FAILURE.getCode());
//			response.sendRedirect(url+"?errorCode="+CustomException.AUTHENTICATION_FAILURE.getCode());
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
