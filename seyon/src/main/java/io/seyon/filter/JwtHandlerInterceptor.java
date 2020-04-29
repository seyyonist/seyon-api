package io.seyon.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.seyon.SeyonApiProperties;


@Component
public class JwtHandlerInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	SeyonApiProperties props;
	
	private static Logger log = LoggerFactory.getLogger(JwtHandlerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		
		request.setAttribute("x-company-id", 7);
		request.setAttribute("x-user-email", "nvijaykarthik@gmail.com");
		request.setAttribute("x-user-name", "vijaykarthik n");
		
		return true;
	}
	
}
