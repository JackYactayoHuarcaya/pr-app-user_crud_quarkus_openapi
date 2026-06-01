package com.pr.api.app.infrastructure.mapper;

import com.pr.api.app.application.model.CreateUserCommand;
import com.pr.api.app.application.model.FindUserCommand;
import com.pr.api.app.application.model.UpdateUserCommand;
import com.pr.model.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "cdi")
public interface UserRestMapper {
    @Mapping(source = "id", target = "id")
    FindUserCommand toCommand(UUID id);
    @Mapping(source = "user_name",target = "name")
    @Mapping(source = "user_age",target = "age")
    @Mapping(source = "user_code",target = "code")
    CreateUserCommand toCreateUserCommand(UserRequest userRequest);
    @Mapping(source = "userRequest.user_name",target = "name")
    UpdateUserCommand toUpdateUserCommand(UUID id,UserRequest userRequest);
}
