package com.pr.api.app.infrastructure.expose.web;

import com.pr.api.UsersApi;
import com.pr.model.UserRequest;
import com.pr.model.UserResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyApi implements UsersApi {
    @Override
    public UserResponse create(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse delete(String id) {
        return null;
    }

    @Override
    public UserResponse update(String id, UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse find() {
        return null;
    }

}
