package com.cherrypicks.tcc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TccZuulServerApplication{

	public static void main(String[] args) {
		SpringApplication.run(TccZuulServerApplication.class, args);
	}
	
	/**
	 * 映射方式:microservice-provider-user-v1-------/v1/microservice-provider-user/**
	 * @return
	 */
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
	    return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
	}
}
