package io.seyon;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.security.Key;

import javax.crypto.SecretKey;

import org.apache.catalina.filters.RemoteAddrFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class SeyonApiApplication {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeyonApiProperties seyonProperties;

	public static void main(String[] args) {
		// SpringApplication.run(SeyonApiApplication.class, args);
		SpringApplicationBuilder app = new SpringApplicationBuilder(SeyonApiApplication.class);
		app.build().addListeners(new ApplicationPidFileWriter("api.pid"));
		app.run(args);

	}

	@Bean
	public Key jwtKey() {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return key;
	}

	@Bean
	public RestTemplate oauthRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebMvcConfigurer interceptorConfigurer() {
		return new WebMvcConfigurer() {
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
				registry.addMapping("/jwt/**").allowCredentials(true)
						.allowedMethods("GET", "POST", "DELETE", "PATCH", "PUT").allowedOrigins("http://localhost:4200")
						.maxAge(3600);
				registry.addMapping("/api/**").allowCredentials(true)
						.allowedMethods("GET", "POST", "DELETE", "PATCH", "PUT").allowedOrigins("http://localhost:4200")
						.maxAge(3600);
				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}

	// @Bean // deactivating the ip based restriction
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
