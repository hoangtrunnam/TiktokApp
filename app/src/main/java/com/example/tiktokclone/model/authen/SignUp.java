package com.example.tiktokclone.model.authen;

public class SignUp {
    private String type;
    private String email;
    private String password;

    public SignUp() {
    }

    public SignUp(String type, String email, String password) {
        this.type = type;
        this.email = email;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
