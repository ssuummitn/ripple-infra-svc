package com.ripple.infrasvc.api.mapper;


import com.ripple.infrasvc.api.dtos.response.SignInUserResponse;
import com.ripple.infrasvc.api.dtos.response.SignUpUserResponse;
import com.ripple.infrasvc.api.dtos.response.VirtualMachine;
import com.ripple.infrasvc.service.dtos.request.CreateVMRequest;
import com.ripple.infrasvc.service.dtos.request.SignInUserRequest;
import com.ripple.infrasvc.service.dtos.request.SignUpUserRequest;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by sumit.nagariya on 15/09/19.
 */
@Mapper
public abstract class ApiServiceMapper {
    public abstract SignUpUserRequest apiServiceSignUpUser(
            com.ripple.infrasvc.api.dtos.request.SignUpUserRequest signUpUserRequest);

    public abstract SignInUserRequest apiServiceSignInUser(
            com.ripple.infrasvc.api.dtos.request.SignInUserRequest signInUserRequest);

    public abstract CreateVMRequest apiServiceCreateVM(
            com.ripple.infrasvc.api.dtos.request.CreateVMRequest createVMRequest);

    public abstract SignInUserResponse serviceApiSignInUser(
            com.ripple.infrasvc.service.dtos.response.SignInUserResponse signInUserResponse);

    public abstract SignUpUserResponse serviceApiSignUpUser(
            com.ripple.infrasvc.service.dtos.response.SignUpUserResponse signUpUserResponse);

    public abstract List<VirtualMachine> serviceApiFetchAllVMForUser(
            List<com.ripple.infrasvc.service.dtos.response.VirtualMachine> virtualMachines);


    public abstract VirtualMachine serviceApiVM(com.ripple.infrasvc.service.dtos.response.VirtualMachine virtualMachine);


}
