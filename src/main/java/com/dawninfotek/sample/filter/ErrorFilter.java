package com.dawninfotek.sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "ErrorFilter",urlPatterns = {"/*"}) 
public class ErrorFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(ErrorFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LogHttpServletResponseWrapper responseWrapper = new LogHttpServletResponseWrapper((HttpServletResponse)response);
		
		//!HttpServletResponse res = (HttpServletResponse) response;
		try {
			chain.doFilter(request, responseWrapper);
		}catch(Throwable ex) {
			
			ex.printStackTrace();
			
			int errorCode = 901; // 901 : business logic error; 905 : system related error
			int status = responseWrapper.getStatus();
			if (status != 200)
				errorCode = 905;
			logger.error("error code:"+errorCode);
		}
		finally {
			int status = responseWrapper.getStatus();
			logger.error("http status:"+status);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
