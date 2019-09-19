package com.ripple.infrasvc.service.dtos.request;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public class SignInUserRequest {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
