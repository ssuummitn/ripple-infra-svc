package com.ripple.infrasvc.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@ApiModel(description = "Response of user signup")
public class SignUpUserResponse {
    @JsonProperty(value = "token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
