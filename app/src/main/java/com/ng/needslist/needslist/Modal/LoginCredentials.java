package com.ng.needslist.needslist.Modal;

/**
 * Created by user on 2/3/2018.
 */

public class LoginCredentials{
    private String email;
    private String password;

    public LoginCredentials(String email, String password){
        this.email = email;
        this.password = password;
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
