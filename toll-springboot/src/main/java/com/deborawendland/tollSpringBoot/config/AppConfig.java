package com.deborawendland.tollSpringBoot.config;

import com.deborawendland.tollSpringBoot.toll.TollService;
import com.deborawendland.cloud.tema05.vehicle.*;
import com.deborawendland.tollSpringBoot.vehicle.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TollService tollService(){
        return new TollService();
    }

    @Bean
    public Beetle beetle(){
        return new Beetle();
    }

    @Bean
    public Bike bike(){
        return new Bike();
    }

    @Bean
    public Bus bus(){
        return new Bus();
    }

    @Bean
    public Motorcycle motorcycle(){
        return new Motorcycle();
    }

    @Bean
    public Truck truck(){
        return new Truck();
    }
}
