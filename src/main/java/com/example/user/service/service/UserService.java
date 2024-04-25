package com.example.user.service.service;


import com.example.user.service.model.entity.Users;
import com.example.user.service.model.request.CreateUsersRequest;
import com.example.user.service.model.response.UsersResponse;

public interface UserService {

    Users getUserById(Long userId);

    UsersResponse insertUser(CreateUsersRequest users);

    void deleteUser(Long userId);

    Users putUser(long userID, Users updatedUser);


}

