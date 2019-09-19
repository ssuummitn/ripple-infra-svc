package com.ripple.infrasvc.api.controller;

import com.ripple.infrasvc.api.dtos.request.SignInUserRequest;
import com.ripple.infrasvc.api.dtos.request.SignUpUserRequest;
import com.ripple.infrasvc.api.dtos.response.SignInUserResponse;
import com.ripple.infrasvc.api.dtos.response.SignUpUserResponse;
import com.ripple.infrasvc.api.mapper.ApiServiceMapper;
import com.ripple.infrasvc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@Api(produces = "http")
@RestController
@RequestMapping("api/v1/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @Autowired
    private ApiServiceMapper apiServiceMapper;


    @ApiOperation(nickname = "create user", value = "create user", notes = "Create user")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "User has been created successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Expired or invalid JWT token"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Something went wrong"),
            @ApiResponse(code = HTTP_UNPROCESSABLE_ENTITY, message = "Username is already in use")})
    @RequestMapping(method = RequestMethod.POST, path = "/signup", produces = MediaType.APPLICATION_JSON)
    public SignUpUserResponse signUpUser(@Valid @RequestBody SignUpUserRequest request) {
        return apiServiceMapper.serviceApiSignUpUser(
                userService.signUp(apiServiceMapper.apiServiceSignUpUser(request)));
    }

    @ApiOperation(nickname = "Sign-in user", value = "Sign-in user", notes = "Sign-in user")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "User has been logged in successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Something went wrong"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Something went wrong"),
            @ApiResponse(code = HTTP_UNPROCESSABLE_ENTITY, message = "Invalid username/password supplied")})
    @RequestMapping(method = RequestMethod.POST, path = "/signin", produces = MediaType.APPLICATION_JSON)
    public SignInUserResponse signInUser(@RequestBody @Valid SignInUserRequest request) {
        return apiServiceMapper.serviceApiSignInUser(
                userService.signIn(apiServiceMapper.apiServiceSignInUser(request)));
    }

    @ApiOperation(nickname = "Delete user", value = "Delete user", notes = "Delete user")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "User has been deleteed successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Expired or invalid JWT token"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Something went wrong"),
            @ApiResponse(code = HTTP_NOT_FOUND, message = "The user doesn't exist"),
            @ApiResponse(code = HTTP_FORBIDDEN, message = "Access denied")})
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{username}")
    public void deleteUser(@PathVariable("username") @NotNull String userName) {
        userService.deleteUser(userName);
    }


}
