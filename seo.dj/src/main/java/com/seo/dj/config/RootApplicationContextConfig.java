package com.seo.dj.config;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

import com.seo.dj.utils.MessageBundleUtil;

@Configuration
@ComponentScan(basePackages = {
		"com.seo.dj"
})
public class RootApplicationContextConfig {
	
	@Bean(name = "common")
    public PropertiesFactoryBean getCommonPropertyBean() throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("/properties/common.properties"));
        bean.afterPropertiesSet();
        return bean;
    }
	
	@Bean(name = "jdbc")
    public PropertiesFactoryBean getDbcpPropertyBean() throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("/properties/jdbc.properties"));
        bean.afterPropertiesSet();
        return bean;
    }

    @Bean
    public MessageBundleUtil messageBundleUtil() throws Exception {

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("utf-8");
        source.setBasename("META-INF/message/message");

        MessageSourceAccessor accessor = new MessageSourceAccessor(source);

        MessageBundleUtil util = new MessageBundleUtil();
        util.setMessageSourceAccessor(accessor);
        return util;
    }
    
}
