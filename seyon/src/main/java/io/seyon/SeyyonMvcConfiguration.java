package io.seyon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SeyyonMvcConfiguration implements WebMvcConfigurer {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeyonApiProperties seyonProperties;

	@Autowired
	@Qualifier("jwtHandlerInterceptor")
	HandlerInterceptor jwtHandlerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("Adding interceptors");
		registry.addInterceptor(jwtHandlerInterceptor).excludePathPatterns(seyonProperties.getAuthExcludeUrl());
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		if (null != seyonProperties.getAllowOriginDomain()) {
			registry.addMapping("/jwt/**").allowCredentials(true)
					.allowedMethods("GET", "POST", "DELETE", "PATCH", "PUT")
					.allowedOrigins(seyonProperties.getAllowOriginDomain()).maxAge(3600);
			registry.addMapping("/api/**").allowCredentials(true)
					.allowedMethods("GET", "POST", "DELETE", "PATCH", "PUT")
					.allowedOrigins(seyonProperties.getAllowOriginDomain()).maxAge(3600);
		}
		WebMvcConfigurer.super.addCorsMappings(registry);

	}

}
