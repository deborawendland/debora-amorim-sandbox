package com.deborawendland.cloud.tema07.twitter.service;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class TwitterTemplateCreator {

    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;

    public TwitterTemplateCreator(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    public Twitter getTwitterTemplate(){
        return  new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }

}
