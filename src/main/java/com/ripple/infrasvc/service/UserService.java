package com.ripple.infrasvc.service;


import com.ripple.infrasvc.service.dtos.request.SignInUserRequest;
import com.ripple.infrasvc.service.dtos.request.SignUpUserRequest;
import com.ripple.infrasvc.service.dtos.response.SignInUserResponse;
import com.ripple.infrasvc.service.dtos.response.SignUpUserResponse;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public interface UserService {

    SignUpUserResponse signUp(SignUpUserRequest user);

    SignInUserResponse signIn(SignInUserRequest user);

    void deleteUser(String user);

}
