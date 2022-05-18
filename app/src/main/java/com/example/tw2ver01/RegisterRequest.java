package com.example.tw2ver01;

public class RegisterRequest {

    private String username;
    private String email;
    private String password;
    private String data_joined = "2020-04-20T12:16:34.566Z";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData_joined() {
        return data_joined;
    }

    public void setData_joined(String data_joined) {
        this.data_joined = data_joined;
    }
}
