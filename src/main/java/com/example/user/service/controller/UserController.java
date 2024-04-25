package com.example.user.service.controller;


import com.example.user.service.model.entity.Users;
import com.example.user.service.model.request.CreateUsersRequest;
import com.example.user.service.model.response.UsersResponse;
import com.example.user.service.repository.UserRepository;
import com.example.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository lRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public Users getUserId(@PathVariable("userId") long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/users/name")
    public List<Users> getUserByName(@RequestParam String name) {
        return lRepo.findByName(name);
    }

    @GetMapping("/users/surname")
    public List<Users> getUserBySurname(@RequestParam String surname) {
        return lRepo.findBySurname(surname);
    }

    @GetMapping("/users/email")
    public List<Users> getUserByEmail(@RequestParam String email) {
        return lRepo.findByEmail(email);
    }

    @GetMapping("/users/phone")
    public List<Users> getUserByPhone(@RequestParam String phone) {
        return lRepo.findByPhone(phone);
    }

    @PostMapping("/user")
    public UsersResponse insertUser(@RequestBody @Valid CreateUsersRequest users) {
        return userService.insertUser(users);
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable long userId){
         userService.deleteUser(userId);
         return "Kullanıcı Silindi";
    }

    @PutMapping("/user/{userId}")
    public Users putUser(@PathVariable Long userId, @RequestBody @Validated Users updatedUser){
        return userService.putUser(userId, updatedUser);
    }


}
