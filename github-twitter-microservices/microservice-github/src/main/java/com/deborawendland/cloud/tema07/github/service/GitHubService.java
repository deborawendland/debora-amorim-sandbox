package com.deborawendland.cloud.tema07.github.service;

import com.deborawendland.cloud.tema07.github.exception.UserNotFoundException;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;

public class GitHubService {

    public int getUserRepositoryNumber(String user){
        RepositoryService repositoryService = new RepositoryService();
        try {
            return repositoryService.getRepositories(user).size();
        } catch (IOException e){
            throw new UserNotFoundException("User not Found: " + user);
        }
    }

}
