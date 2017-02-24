package com.seo.dj.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ApiConfiguration {
	@Value("#{common['api.url']}")
    private String host;
}
