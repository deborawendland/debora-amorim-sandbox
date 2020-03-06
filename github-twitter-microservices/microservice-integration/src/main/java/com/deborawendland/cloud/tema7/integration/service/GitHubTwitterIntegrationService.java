package com.deborawendland.cloud.tema7.integration.service;

import com.deborawendland.cloud.tema7.integration.exception.HttpCommunicationException;
import com.deborawendland.cloud.tema7.integration.exception.UserNotFoundException;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class GitHubTwitterIntegrationService {

    private RestTemplate restTemplate;

    public GitHubTwitterIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int getUserCount(String url){
        try {
            return restTemplate.getForObject(url, Integer.class);
        } catch (HttpStatusCodeException ex){
            if (ex.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                throw new UserNotFoundException(ex.getResponseBodyAsString());
            } else {
                throw new HttpCommunicationException("Error communication with microservice");
            }
        }
    }
}
