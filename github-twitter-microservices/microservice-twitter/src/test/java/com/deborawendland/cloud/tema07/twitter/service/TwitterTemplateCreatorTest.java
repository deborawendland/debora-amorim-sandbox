package com.deborawendland.cloud.tema07.twitter.service;

import com.deborawendland.cloud.tema07.twitter.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TwitterTemplateCreatorTest {

    @Autowired
    private TwitterTemplateCreator twitterTemplateCreator;

    @Test
    public void givenValidAccountSpringAtSO_whenRetrievingTwitterClient_thenNoException() {
        Assert.assertNotNull(twitterTemplateCreator.getTwitterTemplate());
    }


}