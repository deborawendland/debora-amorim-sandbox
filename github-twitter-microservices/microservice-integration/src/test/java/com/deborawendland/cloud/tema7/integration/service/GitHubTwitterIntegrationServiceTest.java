package com.deborawendland.cloud.tema7.integration.service;

import com.deborawendland.cloud.tema7.integration.config.AppConfig;
import com.deborawendland.cloud.tema7.integration.exception.UserNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestPropertySource("classpath:integration.properties")
public class GitHubTwitterIntegrationServiceTest {

    private String urlTwitter;
    private String urlGithub;

    @Autowired
    private GitHubTwitterIntegrationService integrationService;

    @Autowired
    private Environment environment;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
        this.urlGithub = environment.getProperty("integration.url") + environment.getProperty("integration.github.port") + "/";
        this.urlTwitter = environment.getProperty("integration.url") + environment.getProperty("integration.twitter.port") + "/";

    }

    @Test
    public void getValidUserTweetNumber() {
        String userName = "deboizando";
        Assert.assertTrue(integrationService.getUserCount(urlTwitter + userName) > 31100);
    }

    @Test
    public void getInvalidUserTweetNumber() {
        String userName = "debbzando";
        thrown.expect(UserNotFoundException.class);
        thrown.expectMessage("User not Found: " + userName);
        integrationService.getUserCount(urlTwitter + userName);
    }

    @Test
    public void getValidUserRepositoryNumber() {
        String userName = "deborawendland";
        Assert.assertTrue(integrationService.getUserCount(urlGithub + userName) == 8);
    }

    @Test
    public void getInvalidUserRepositoryNumber() {
        String userName = "debbzando";
        thrown.expect(UserNotFoundException.class);
        thrown.expectMessage("User not Found: " + userName);
        integrationService.getUserCount(urlGithub + userName);
    }
}