package com.deborawendland.cloud.tema07.twitter.service;

import com.deborawendland.cloud.tema07.twitter.config.AppConfig;
import com.deborawendland.cloud.tema07.twitter.exception.UserNotFoundException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TwitterServiceTest {

    @Autowired
    private TwitterService twitterService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getValidUserTweetsNumberTest() {
        Assert.assertTrue(twitterService.getUserTweetsNumber("deboizando") > 31100);
    }

    @Test
    public void getInvalidUserTweetsNumberTest() {
        String userName = "debbzando";
        thrown.expect(UserNotFoundException.class);
        thrown.expectMessage("User not Found: " + userName);
        twitterService.getUserTweetsNumber(userName);
    }
}