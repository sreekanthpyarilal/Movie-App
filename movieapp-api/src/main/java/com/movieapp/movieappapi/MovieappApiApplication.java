package com.movieapp.movieappapi;

import org.springframework.boot.SpringApplication;import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.context.annotation.Bean;



//import com.movieapp.movieappapi.jwtfilter.JwtFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieappApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieappApiApplication.class, args);
		
		
	}
//	@Bean
//	public FilterRegistrationBean<JwtFilter> jwtFilter() {
//		final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new JwtFilter());
//		registrationBean.addUrlPatterns();
//		return registrationBean;
//	}


}
