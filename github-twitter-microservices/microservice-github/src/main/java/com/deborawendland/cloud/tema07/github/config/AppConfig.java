package com.deborawendland.cloud.tema07.github.config;

import com.deborawendland.cloud.tema07.github.service.GitHubService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GitHubService gitHubService(){
        return new GitHubService();
    }
}
