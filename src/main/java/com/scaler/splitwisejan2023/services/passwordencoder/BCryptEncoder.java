package com.scaler.splitwisejan2023.services.passwordencoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//BCrypt is one of the ways to encrypt the password.
//
@Service
public class BCryptEncoder implements PasswordEncoder {
    private BCryptPasswordEncoder springBcryptEncoder = new BCryptPasswordEncoder();

    @Override
    public String getEncodedPassword(String realPassword) {
        return springBcryptEncoder.encode(realPassword);
    }

    @Override
    public boolean matches(String realPassword, String hashedPassword) {
        return springBcryptEncoder.matches(realPassword, hashedPassword);
    }
}


// User, Group ->
