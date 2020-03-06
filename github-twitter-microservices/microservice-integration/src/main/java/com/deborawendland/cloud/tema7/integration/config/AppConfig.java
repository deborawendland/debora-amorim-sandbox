package com.deborawendland.cloud.tema7.integration.config;

import com.deborawendland.cloud.tema7.integration.service.GitHubTwitterIntegrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public GitHubTwitterIntegrationService gitHubTwitterIntegrationService(RestTemplate restTemplate){
        return new GitHubTwitterIntegrationService(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
