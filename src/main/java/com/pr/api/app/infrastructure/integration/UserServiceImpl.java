package com.pr.api.app.infrastructure.integration;

import com.pr.api.app.application.model.CreateUserCommand;
import com.pr.api.app.application.model.DeleteUserCommand;
import com.pr.api.app.application.model.FindUserCommand;
import com.pr.api.app.application.model.UpdateUserCommand;
import com.pr.api.app.application.provider.UserService;
import com.pr.api.app.domain.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<>();

    @Override
    public User createUser(CreateUserCommand createUserCommand) {
        User user = new User();
        user.setName(createUserCommand.name());
        user.setAge(createUserCommand.age());
        user.setId(UUID.randomUUID());
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(UpdateUserCommand updateUserCommand) {
        User userFind = users.stream().filter(user->user.getId().equals(updateUserCommand.id()) ).findFirst().orElse(null);
        if (userFind == null) {
            return null;
        }else{
            userFind.setName(updateUserCommand.name());
            userFind.setAge(updateUserCommand.age());
            userFind.setCode(updateUserCommand.code());
            return userFind;
        }
    }

    @Override
    public User deleteUser(DeleteUserCommand deleteUserCommand) {
        User userFind = users.stream().filter(user -> user.getId().equals(deleteUserCommand.id())).findFirst().orElse(null);
        if (userFind == null) {
            return null;
        }else {
            users.remove(userFind);
            return userFind;
        }
    }

    @Override
    public User findUser(FindUserCommand findUserCommand) {
        return  users.stream().filter(user -> user.getId().equals(findUserCommand.id())).findFirst().orElse(null);
    }
}
