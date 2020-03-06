package com.deborawendland.cloud.tema07.twitter.config;

import com.deborawendland.cloud.tema07.twitter.service.TwitterService;
import com.deborawendland.cloud.tema07.twitter.service.TwitterTemplateCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:twitter.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public TwitterTemplateCreator twitterTemplateCreator(){
        String consumerKey = environment.getProperty("twitter.consumerKey");
        String consumerSecret = environment.getProperty("twitter.consumerSecret");
        String accessToken = environment.getProperty("twitter.accessToken");
        String accessTokenSecret = environment.getProperty("twitter.accessTokenSecret");
        return new TwitterTemplateCreator(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }

    @Bean
    public TwitterService twitterService(){
        return new TwitterService(twitterTemplateCreator().getTwitterTemplate());
    }

}
