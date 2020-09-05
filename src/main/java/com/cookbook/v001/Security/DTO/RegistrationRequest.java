package com.cookbook.v001.Security.DTO;

public class RegistrationRequest {

    private final String name;
    private final String username;
    private final String password;
    private final String email;

    public RegistrationRequest(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
