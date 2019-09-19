package com.ripple.infrasvc.api.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@ApiModel(description = "Request of user signin")
public class SignInUserRequest {
    @ApiModelProperty(name = "user_name", required = true)
    @NotBlank
    @Size(min = 4, max = 50, message = "Name must be between 4 and 50 characters")
    @JsonProperty(value = "user_name", required = true)
    private String name;

    @ApiModelProperty(name = "password", required = true)
    @NotBlank
    @Size(min = 8, message = "Minimum password length: 8 characters")
    @JsonProperty(value = "password", required = true)
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
