package com.pr.api.app.application.business;

import com.pr.api.app.application.model.UpdateUserCommand;
import com.pr.api.app.application.provider.UserService;
import com.pr.api.app.domain.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateUser {
    @Inject
    UserService  userService;
    public User execute(UpdateUserCommand updateUserCommand) {
        return userService.updateUser(updateUserCommand);
    }
}
