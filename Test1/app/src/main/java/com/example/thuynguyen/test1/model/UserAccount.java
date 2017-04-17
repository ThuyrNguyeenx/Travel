package com.example.thuynguyen.test1.model;

import java.io.Serializable;

/**
 * Created by ThuyNguyen on 01/04/2017.
 */
public class UserAccount implements Serializable {
    private String email, password;

    public UserAccount() {
    }

    public UserAccount(String email, String password) {
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
