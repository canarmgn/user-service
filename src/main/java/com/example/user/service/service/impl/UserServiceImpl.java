package com.example.user.service.service.impl;

import com.example.user.service.model.entity.Users;
import com.example.user.service.model.request.CreateUsersRequest;
import com.example.user.service.model.response.UsersResponse;
import com.example.user.service.repository.AddressRepository;
import com.example.user.service.repository.UserRepository;
import com.example.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public AddressRepository addressRepository;


    @Override
    public Users getUserById(Long userId) {
        Users user = userRepository.findById(userId).orElse(null);
        return user;
    }

    @Override
    public UsersResponse insertUser(CreateUsersRequest userRequest) {
        Users newUser = createUser(userRequest);
        return prepareResponse(newUser);
    }

    private static UsersResponse prepareResponse(Users newUser) {
        UsersResponse response = new UsersResponse();
        response.setName(newUser.getName());
        response.setSurname(newUser.getSurname());
        response.setEmail(newUser.getEmail());
        response.setPhone(newUser.getPhone());
        return response;
    }

    private Users createUser(CreateUsersRequest userRequest) {
        Users newUser = new Users();
        newUser.setName(userRequest.getName());
        newUser.setSurname(userRequest.getSurname());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPhone(userRequest.getPhone());

        userRepository.save(newUser);
        return newUser;
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Users putUser(long userId, Users updatedUser) {
        Optional<Users> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {

            Users users = existingUser.get();
            users.setName(updatedUser.getName());
            users.setSurname(updatedUser.getSurname());
            users.setEmail(updatedUser.getEmail());
            users.setPhone(updatedUser.getPhone());

            return userRepository.save(users);
        }
        return null;

    }


}
