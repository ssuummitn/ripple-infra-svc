package com.ripple.infrasvc.service.dtos.request;

import com.ripple.infrasvc.api.dtos.enums.Role;

import java.util.List;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public class SignUpUserRequest {

    private String name;
    private String email;
    private String mobileNo;
    private String password;

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
