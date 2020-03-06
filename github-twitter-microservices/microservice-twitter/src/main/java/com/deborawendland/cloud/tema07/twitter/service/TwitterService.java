package com.deborawendland.cloud.tema07.twitter.service;

import com.deborawendland.cloud.tema07.twitter.exception.UserNotFoundException;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.twitter.api.Twitter;

public class TwitterService {

    private Twitter twitter;

    public TwitterService(Twitter twitter) {
        this.twitter = twitter;
    }

    public int getUserTweetsNumber(String user){
        try {
            return twitter.userOperations().getUserProfile(user).getStatusesCount();
        } catch (ResourceNotFoundException e){
            throw new UserNotFoundException("User not Found: " + user);
        }
    }

}
