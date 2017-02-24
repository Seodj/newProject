package com.seo.dj.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.seo.dj.interceptor.LoginIntercepter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.seo.dj.controller"
})
public class ServletContextConfig extends WebMvcConfigurerAdapter {
	
	 @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        converters.add(jackson2HttpMessageConverter());
	        super.configureMessageConverters(converters);
	    }

	    @Bean
	    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
	        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        objectMapper.registerModule(new Jdk8Module());
	        jsonConverter.setObjectMapper(objectMapper);
	        return jsonConverter;
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(loginIntercepter());
	        super.addInterceptors(registry);
	    }

	    @Bean
	    public LoginIntercepter loginIntercepter() {
	    	LoginIntercepter intercepter = new LoginIntercepter();
	        return intercepter;
	    }
}