package com.pr.api.app.infrastructure.mapper;

import com.pr.api.app.application.model.CreateUserCommand;
import com.pr.api.app.application.model.DeleteUserCommand;
import com.pr.api.app.application.model.FindUserCommand;
import com.pr.api.app.application.model.UpdateUserCommand;
import com.pr.api.app.domain.User;
import com.pr.model.UserRequest;
import com.pr.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "cdi")
public interface UserRestMapper {
    @Mapping(source = "id", target = "id")
    FindUserCommand toFindUserCommand(UUID id);
    @Mapping(source = "id", target = "id")
    DeleteUserCommand toDeleteUserCommand(UUID id);
    @Mapping(source = "userName",target = "name")
    @Mapping(source = "userAge",target = "age")
    @Mapping(source = "userCode",target = "code")
    CreateUserCommand toCreateUserCommand(UserRequest userRequest);
    @Mapping(source = "userRequest.userName",target = "name")
    @Mapping(source = "userRequest.userAge",target = "age")
    @Mapping(source = "userRequest.userCode",target = "code")
    UpdateUserCommand toUpdateUserCommand(UUID id,UserRequest userRequest);
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name",target = "userName")
    @Mapping(source = "age",target = "userAge")
    @Mapping(source = "code",target = "userCode")
    UserResponse toUserResponse(User user);
}