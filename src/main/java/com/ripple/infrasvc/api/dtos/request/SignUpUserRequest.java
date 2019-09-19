package com.ripple.infrasvc.api.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ripple.infrasvc.api.dtos.enums.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@ApiModel(description = "Request of user signup")
public class SignUpUserRequest {

    @ApiModelProperty(name = "user_name", required = true)
    @NotBlank
    @Size(min = 4, max = 50, message = "Name must be between 4 and 50 characters")
    @JsonProperty(value = "user_name", required = true)
    private String name;

    @ApiModelProperty(name = "email", required = true)
    @NotBlank
    @Email(message = "Email is not valid")
    @JsonProperty(value = "email", required = true)
    private String email;

    @ApiModelProperty(name = "mobileNo", required = true)
    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Mobile no is not valid")
    @JsonProperty(value = "mobileNo", required = true)
    private String mobileNo;

    @ApiModelProperty(name = "password", required = true)
    @NotBlank
    @Size(min = 8, message = "Minimum password length is 8 characters")
    @JsonProperty(value = "password", required = true)
    private String password;

    @ApiModelProperty(name = "role", required = true)
    @JsonProperty(value = "role", required = true)
    private List<Role> role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
