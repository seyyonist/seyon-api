package io.seyon.filter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.seyon.SeyonApiProperties;
import io.seyon.oauth2.OauthUserInfo;
import io.seyon.oauth2.SeyyonJwtHandler;

@Component
public class JwtHandlerInterceptor extends HandlerInterceptorAdapter {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeyonApiProperties props;

	@Autowired
	SeyyonJwtHandler jwtHandler;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getMethod().contentEquals("OPTIONS")) {
			return true;
		}
		Enumeration<String> x = request.getHeaderNames();
		log.trace("**********************{}*******************************", request.getMethod());
		while (x.hasMoreElements()) {
			String y = x.nextElement();	
			log.trace(y);
			log.trace(request.getHeader(y));
		}
		log.trace("*****************************************************");
		String header_authorization = request.getHeader("Authorization");
		String headerSelectedCompany = request.getHeader("SelectedCompany");
		String skipCompCheckHeader=request.getHeader("skipCompCheck");
		String token = (StringUtils.isEmpty(header_authorization) ? null : header_authorization.split(" ")[1]);

		if (StringUtils.isEmpty(header_authorization) && token == null) {
			log.info("Token Not found in header.");
			return false;
		} else {
			OauthUserInfo userinfo = jwtHandler.parseToken(token);
			request.setAttribute("x-user-email", userinfo.getEmail());
			request.setAttribute("x-user-name", userinfo.getName());
		}

		String selectedCompany = (StringUtils.isEmpty(headerSelectedCompany) ? null : headerSelectedCompany);
		String skipCompCheck=(StringUtils.isEmpty(skipCompCheckHeader) ? "N" : skipCompCheckHeader);
		
		if (skipCompCheck.equalsIgnoreCase("N") && null == selectedCompany) {
			log.info("Company Not selected.");
			return false;
		} else {
			request.setAttribute("x-company-id", selectedCompany);
		}

		return true;
	}

}
