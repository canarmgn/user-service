package com.example.user.service.model.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {

    private Long userId;
    private String city;
    private String street;
    private String no;
}
