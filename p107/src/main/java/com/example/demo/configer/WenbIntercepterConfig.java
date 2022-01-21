package com.example.demo.configer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptors.testinterceptor;

@Configuration
public class WenbIntercepterConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		InterceptorRegistration registration=registry.addInterceptor(new testinterceptor());
		registration.addPathPatterns("/**");
		registration.excludePathPatterns("/load","/**/*.css","/**/*.js","/**/*.html","/images/**","/index.html");
	}

}
