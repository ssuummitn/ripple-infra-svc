package com.ripple.infrasvc.service.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public class SignInUserResponse {
    @JsonProperty(value = "token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
