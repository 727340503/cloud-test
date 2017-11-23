package com.cherrypicks.tcc.cms.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cherrypicks.tcc.cms.api.config.DataSourceConfig;
import com.cherrypicks.tcc.cms.api.config.RedisConfig;
import com.cherrypicks.tcc.cms.api.config.WebConfig;

@SpringBootApplication
@EnableScheduling
@Import({WebConfig.class, DataSourceConfig.class, RedisConfig.class})
@EnableEurekaClient
public class TccCmsMerchantApplication {

    public static void main(final String[] args) {
    	SpringApplication.run(TccCmsMerchantApplication.class, args);
    }
}
