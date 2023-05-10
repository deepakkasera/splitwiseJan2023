package com.scaler.splitwisejan2023.services.passwordencoder;

public interface PasswordEncoder {

    String getEncodedPassword(String realPassword);

    boolean matches(String realPassword, String hashedPassword);
}
