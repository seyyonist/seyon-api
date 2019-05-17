package io.seyon.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.seyon.SeyonApiProperties;


@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	SeyonApiProperties props;
	
	private static Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		
		String gatewayToken = request.getHeader("app_token");
		
		if (gatewayToken == null) {
            log.error("No Gateway Token found in request headers");
            throw new AuthorizationServiceException("No Gateway token found in request headers");
        }
		log.info("Recieved GW app id {}",gatewayToken);
		String digestToken = DigestUtils.sha256Hex(props.getAppId());
		log.debug("Hashed GW id {} and APP Id {}",gatewayToken,digestToken);
		
		if(!gatewayToken.equals(digestToken)) {
			log.error("Invalid application acccess , Gateway token missmatch");
            throw new AuthorizationServiceException("No Gateway token found in request headers");
		}
		log.debug("Application Access Allowed");
		
		return true;
	}
	
}
