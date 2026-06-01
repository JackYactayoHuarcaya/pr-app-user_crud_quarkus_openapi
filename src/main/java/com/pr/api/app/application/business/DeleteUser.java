package com.pr.api.app.application.business;

import com.pr.api.app.application.model.DeleteUserCommand;
import com.pr.api.app.application.provider.UserService;
import com.pr.api.app.domain.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteUser {
    @Inject
    private UserService userService;
    public User execute(DeleteUserCommand deleteUserCommand) {
        return userService.deleteUser(deleteUserCommand);
    }
}
