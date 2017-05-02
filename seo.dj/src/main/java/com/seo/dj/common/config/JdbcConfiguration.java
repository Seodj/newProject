package com.seo.dj.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class JdbcConfiguration {
	@Value("#{jdbc['master.sms.driverClassName']}")
    private String driverName;
	@Value("#{jdbc['master.sms.url']}")
    private String url;
	@Value("#{jdbc['master.sms.username']}")
    private String userName;
	@Value("#{jdbc['master.sms.password']}")
    private String password;
	@Value("#{jdbc['initialSize']}")
    private int initialSize;
	@Value("#{jdbc['minIdle']}")
    private int minIdle;
	@Value("#{jdbc['maxIdle']}")
    private int maxIdle;
	@Value("#{jdbc['maxTotal']}")
    private int maxTotal;
	@Value("#{common['api.url']}")
	private String test;
    
}
