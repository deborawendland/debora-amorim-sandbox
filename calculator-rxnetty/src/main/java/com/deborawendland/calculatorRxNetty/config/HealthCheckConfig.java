package com.deborawendland.calculatorRxNetty.config;

import com.deborawendland.calculatorRxNetty.rxNetty.HealthCheckResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  "com.deborawendland.cloud.tema08")
public class HealthCheckConfig {

    @Bean
    public HealthCheckResource healthCheckResource(){
        return new HealthCheckResource();
    }
}
