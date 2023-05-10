package com.scaler.splitwisejan2023.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String username;
    private String password;
    private String phoneNumber;
}

// {
//    username: "Sanket",
//    password: "verycool",
//    phoneNumber: "12345",
// }