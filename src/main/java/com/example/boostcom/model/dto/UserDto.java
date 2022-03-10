package com.example.boostcom.model.dto;

public class UserDto {

    private String username;
    private String password;



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
