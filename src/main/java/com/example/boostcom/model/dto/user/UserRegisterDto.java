package com.example.boostcom.model.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRegisterDto {
    @Email(message = "enter valid email address")
    private String email;
    @Size(min=2,max=15,message ="the username must be between 2 and 15 characters long")
    private String username;
    @Size(min=2,max=10,message ="the name must be between 2 and 10 characters long")
    private String firstName;
    private String lastName;
    @Size(min =2,message ="the password length must be minimum 2 characters")
    private String password;



    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
