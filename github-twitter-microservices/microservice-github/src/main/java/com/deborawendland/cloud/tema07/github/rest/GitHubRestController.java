package com.deborawendland.cloud.tema07.github.rest;

import com.deborawendland.cloud.tema07.github.config.AppConfig;
import com.deborawendland.cloud.tema07.github.exception.UserNotFoundException;
import com.deborawendland.cloud.tema07.github.service.GitHubService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class GitHubRestController {

    private ApplicationContext applicationContext;
    private GitHubService gitHubService;

    public GitHubRestController() {
        this.applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.gitHubService = (GitHubService) applicationContext.getBean("gitHubService");
    }

    @GetMapping("/{user}")
    @ResponseBody
    public int getGitHubUserRepositoryNumber(@PathVariable String user){
        return gitHubService.getUserRepositoryNumber(user);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(UserNotFoundException ex){
        return ex.getMessage();
    }

}
