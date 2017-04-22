package com.multiple.root.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharsetFilter
 */
public class CharsetFilter implements Filter {
	private String encoding;
    /**
     * Default constructor. 
     */
    public CharsetFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		  // Respect the client-specified character encoding
	    // (see HTTP specification section 3.4.1)
	    if(null == request.getCharacterEncoding())
	      request.setCharacterEncoding(encoding);


	    /**
		 * Set the default response content type and encoding
		 */
		 response.setContentType("text/html; charset=UTF-8");
		 response.setCharacterEncoding("UTF-8");


		 chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 	encoding = fConfig.getInitParameter("requestEncoding");

		    if( encoding==null ) encoding="UTF-8";
	}

}
