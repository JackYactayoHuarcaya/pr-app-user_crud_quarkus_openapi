package com.pr.api.app.infrastructure.expose.web;

import com.pr.api.UsersApi;
import com.pr.api.app.application.business.CreateUser;
import com.pr.api.app.application.business.DeleteUser;
import com.pr.api.app.application.business.FindUser;
import com.pr.api.app.application.business.UpdateUser;
import com.pr.api.app.application.model.CreateUserCommand;
import com.pr.api.app.application.model.DeleteUserCommand;
import com.pr.api.app.application.model.FindUserCommand;
import com.pr.api.app.application.model.UpdateUserCommand;
import com.pr.api.app.domain.User;
import com.pr.api.app.infrastructure.mapper.UserRestMapper;
import com.pr.model.UserRequest;
import com.pr.model.UserResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;

import java.util.UUID;

@ApplicationScoped
public class MyApi implements UsersApi {
    @Inject
    UserRestMapper  userRestMapper;
    @Inject
    CreateUser createUser;
    @Inject
    DeleteUser deleteUser;
    @Inject
    UpdateUser updateUser;
    @Inject
    FindUser findUser;

    @Override
    public UserResponse create(UserRequest userRequest) {
        CreateUserCommand createUserCommand = userRestMapper.toCreateUserCommand(userRequest);
        User user = createUser.execute(createUserCommand);
        return userRestMapper.toUserResponse(user);
    }

    @Override
    public UserResponse delete(@PathParam("id") String id) {
        DeleteUserCommand deleteUserCommand = userRestMapper.toDeleteUserCommand(UUID.fromString(id));
        User user = deleteUser.execute(deleteUserCommand);
        return userRestMapper.toUserResponse(user);
    }

    @Override
    public UserResponse update(String id, UserRequest userRequest) {
        UpdateUserCommand updateUserCommand = userRestMapper.toUpdateUserCommand(UUID.fromString(id), userRequest);
        User user = updateUser.execute(updateUserCommand);
        return userRestMapper.toUserResponse(user);
    }

    @Override
    public UserResponse find(String id) {
        FindUserCommand findUserCommand = userRestMapper.toFindUserCommand(UUID.fromString(id));
        User user = findUser.execute(findUserCommand);
        return userRestMapper.toUserResponse(user);
    }
}
