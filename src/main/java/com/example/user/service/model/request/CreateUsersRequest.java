package com.example.user.service.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUsersRequest {

    @NotNull(message = "İsim boş olamaz")
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private String phone;
}
