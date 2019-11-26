package com.socgen.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class EmployeeDataSourceConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource()
	{
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(env.getProperty("employee.datasource.driverClassName"));
		dataSource.setJdbcUrl(env.getProperty("employee.datasource.url"));
		dataSource.setUsername(env.getProperty("employee.datasource.username"));
		dataSource.setPassword(env.getProperty("employee.datasource.password"));
		return dataSource;
	}
	
}
