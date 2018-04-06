package io.seyon.filter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter{
	private static Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		
		Enumeration<String> names=request.getHeaderNames();
		while(names.hasMoreElements()) {
			log.info("Header Added : {} ",request.getHeader(names.nextElement()));
		}
		return true;
	}
	
}
