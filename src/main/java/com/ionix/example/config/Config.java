package com.ionix.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

	@Bean
	@ConfigurationProperties(prefix="search")
	public SearchConfig propertiesSearch() {
		return new SearchConfig();
	}
	
}
