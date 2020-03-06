package com.deborawendland.cloud.tema7.integration.rest;

import com.deborawendland.cloud.tema7.integration.config.AppConfig;
import com.deborawendland.cloud.tema7.integration.exception.HttpCommunicationException;
import com.deborawendland.cloud.tema7.integration.exception.UserNotFoundException;
import com.deborawendland.cloud.tema7.integration.service.GitHubTwitterIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@PropertySource("classpath:integration.properties")
public class GitHubTwitterIntegrationRestController {

    private ApplicationContext applicationContext;
    private GitHubTwitterIntegrationService integrationService;

    @Autowired
    private Environment environment;

    public GitHubTwitterIntegrationRestController(){
        this.applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.integrationService = (GitHubTwitterIntegrationService) applicationContext.getBean("gitHubTwitterIntegrationService");
    }

    @GetMapping("/github/{user}")
    @ResponseBody
    public int getUserRepositoryNumber(@PathVariable String user){
        String githubUrl = environment.getProperty("integration.github.url") + environment.getProperty("integration.github.port") + "/";
        return integrationService.getUserCount(githubUrl + user);
    }

    @GetMapping("/twitter/{user}")
    @ResponseBody
    public int getUserTweetNumber(@PathVariable String user){
        String twitterUrl = environment.getProperty("integration.twitter.url") + environment.getProperty("integration.twitter.port") + "/";;
        return integrationService.getUserCount(twitterUrl + user);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(UserNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(HttpCommunicationException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String httpCommunicationExceptionHandler(HttpCommunicationException ex){
        return ex.getMessage();
    }

}




