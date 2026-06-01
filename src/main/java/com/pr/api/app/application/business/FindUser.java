package com.pr.api.app.application.business;

import com.pr.api.app.application.model.CreateUserCommand;
import com.pr.api.app.application.model.FindUserCommand;
import com.pr.api.app.application.provider.UserService;
import com.pr.api.app.domain.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindUser {
    @Inject
    private UserService userService;
    public User execute(FindUserCommand findUserCommand) {
        return userService.findUser(findUserCommand);
    }
}
