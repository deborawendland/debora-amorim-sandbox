package com.deborawendland.cloud.tema07.twitter.rest;

import com.deborawendland.cloud.tema07.twitter.config.AppConfig;
import com.deborawendland.cloud.tema07.twitter.exception.UserNotFoundException;
import com.deborawendland.cloud.tema07.twitter.service.TwitterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class TwitterRestController {

    private ApplicationContext applicationContext;
    private TwitterService twitterService;

    public TwitterRestController(){
        this.applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.twitterService = (TwitterService) applicationContext.getBean("twitterService");
    }

    @GetMapping("/{user}")
    @ResponseBody
    public int getUserTweetNumber(@PathVariable String user){
        return twitterService.getUserTweetsNumber(user);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(UserNotFoundException ex){
        return ex.getMessage();
    }

}
