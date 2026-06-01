package com.pr.api.app.application.provider;

import com.pr.api.app.application.model.CreateUserCommand;
import com.pr.api.app.application.model.DeleteUserCommand;
import com.pr.api.app.application.model.FindUserCommand;
import com.pr.api.app.application.model.UpdateUserCommand;
import com.pr.api.app.domain.User;

public interface UserService {
    User createUser(CreateUserCommand createUserCommand);
    User deleteUser(DeleteUserCommand deleteUserCommand);
    User findUser(FindUserCommand findUserCommand);
    User updateUser(UpdateUserCommand updateUserCommand);
}
