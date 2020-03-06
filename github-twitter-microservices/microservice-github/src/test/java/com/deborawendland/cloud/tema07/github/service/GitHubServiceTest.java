package com.deborawendland.cloud.tema07.github.service;

import com.deborawendland.cloud.tema07.github.config.AppConfig;
import com.deborawendland.cloud.tema07.github.exception.UserNotFoundException;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class GitHubServiceTest {

    @Autowired
    private GitHubService gitHubService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getValidUserRepositoryNumber() {
        Assert.assertTrue(gitHubService.getUserRepositoryNumber("deborawendland") == 8);
    }

    @Test
    public void getInvalidUserRepositoryNumber() {
        String userName = "debbzando";
        thrown.expect(UserNotFoundException.class);
        thrown.expectMessage("User not Found: " + userName);
        gitHubService.getUserRepositoryNumber(userName);
    }

}