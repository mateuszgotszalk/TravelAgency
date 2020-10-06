package com.gotszalk.travelservice.userPackage.model;

import javax.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "firstName cannot be empty")
    private String firstName;

    @NotBlank(message = "surname cannot be empty")
    private String surname;

    @NotBlank(message = "password cannot be empty")
    private String password;

    @NotBlank(message = "email cannot be empty")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
