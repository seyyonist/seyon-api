package io.seyon;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.catalina.filters.RemoteAddrFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SeyonApiApplication {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeyonApiProperties seyonProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SeyonApiApplication.class, args);
	}

	
	@Bean
	public WebMvcConfigurer interceptorConfigurer() {
		return new WebMvcConfigurer() {
			@Autowired
			HandlerInterceptor securityInterceptor;

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				log.info("Adding interceptors");
				registry.addInterceptor(securityInterceptor).excludePathPatterns(seyonProperties.getAuthExcludeUrl());
				WebMvcConfigurer.super.addInterceptors(registry);
			}
		};
	}

	
	//@Bean  // deactivating the ip based restriction
	public FilterRegistrationBean<RemoteAddrFilter> remoteAddressFilter() {

	    FilterRegistrationBean<RemoteAddrFilter> filterRegistrationBean = new FilterRegistrationBean<>();
	    RemoteAddrFilter filter = new RemoteAddrFilter();
	    
	    filter.setAllow(seyonProperties.getRestrictIp());
	    filter.setDenyStatus(404);

	    filterRegistrationBean.setFilter(filter);
	    filterRegistrationBean.addUrlPatterns("/*");

	    return filterRegistrationBean;

	}

}
