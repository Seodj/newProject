package com.seo.dj.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seo.dj.common.config.JdbcConfiguration;

@Configuration
@MapperScan(basePackages =
		{"com.seo.dj.mapper"})
public class DataConfig {
	@Autowired
	private JdbcConfiguration jdbcConfiguration;
	@Autowired
	private ApplicationContext applicationContext;
	
	private final String PACKAGE_NAME = "com.seo.dj.model";
	
	@Bean
	public SqlSessionFactoryBean toastSmsSqlSessionFactory() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/spring/mybatis/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/test/*Mapper.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage(PACKAGE_NAME);
		sqlSessionFactoryBean.setFailFast(true);
		
		return sqlSessionFactoryBean;
	}
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(jdbcConfiguration.getDriverName());
		dataSource.setUrl(jdbcConfiguration.getUrl());
		dataSource.setUsername(jdbcConfiguration.getUserName());
		dataSource.setPassword(jdbcConfiguration.getPassword());
		dataSource.setInitialSize(jdbcConfiguration.getInitialSize());
		dataSource.setMinIdle(jdbcConfiguration.getMinIdle());
		dataSource.setMaxIdle(jdbcConfiguration.getMaxIdle());
		dataSource.setMaxTotal(jdbcConfiguration.getMaxTotal());
		dataSource.setDefaultAutoCommit(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);
		dataSource.setValidationQuery("SELECT 1");
		
		return dataSource;
	}
	
}
