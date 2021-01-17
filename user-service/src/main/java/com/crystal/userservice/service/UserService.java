package com.crystal.userservice.service;

import com.crystal.userservice.entity.User;

public interface UserService {

    User registerUser(User input);

    Iterable<User> findAll();
}
