package com.scaler.splitwisejan2023.controllers;

import com.scaler.splitwisejan2023.dtos.RegisterUserRequestDto;
import com.scaler.splitwisejan2023.dtos.RegisterUserResponseDto;
import com.scaler.splitwisejan2023.dtos.UpdateProfileRequestDto;
import com.scaler.splitwisejan2023.dtos.UpdateProfileResponseDto;
import com.scaler.splitwisejan2023.models.User;
import com.scaler.splitwisejan2023.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // /users/get/{id} -> @PathVariable
    @PostMapping("/users/register")
    public RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto request) {
        User user = userService.registerUser(
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername()
        );

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }

    @PutMapping("/users/update")
    public UpdateProfileResponseDto updateProfile(@RequestBody UpdateProfileRequestDto request) {
        User user = userService.updateProfile(
                request.getUserId(),
                request.getNewPassword()
        );

        UpdateProfileResponseDto response = new UpdateProfileResponseDto();
        response.setUser(user);
        return response;
    }

}
