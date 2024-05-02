package com.example.user.service.model.response;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.bridge.IMessage;

import javax.websocket.OnMessage;

@Getter
@Setter

public class UsersResponse {

    private String name;
    private String surname;
    private  String email;
    private  String phone;

}
