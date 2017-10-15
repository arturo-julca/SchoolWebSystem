package com.komodo.school.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages={"com.komodo.school"})
public class TestPersistenceConfiguration {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource setH2TestDataSource(){
		return DataSourceBuilder.create().build();
	}
}
