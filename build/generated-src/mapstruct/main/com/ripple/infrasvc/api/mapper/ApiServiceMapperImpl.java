package com.ripple.infrasvc.api.mapper;

import com.ripple.infrasvc.api.dtos.enums.Role;
import com.ripple.infrasvc.api.dtos.request.CreateVMRequest;
import com.ripple.infrasvc.api.dtos.request.SignInUserRequest;
import com.ripple.infrasvc.api.dtos.request.SignUpUserRequest;
import com.ripple.infrasvc.service.dtos.response.SignInUserResponse;
import com.ripple.infrasvc.service.dtos.response.SignUpUserResponse;
import com.ripple.infrasvc.service.dtos.response.VirtualMachine;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-20T01:03:17+0530",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class ApiServiceMapperImpl extends ApiServiceMapper {

    @Override
    public com.ripple.infrasvc.service.dtos.request.SignUpUserRequest apiServiceSignUpUser(SignUpUserRequest signUpUserRequest) {
        if ( signUpUserRequest == null ) {
            return null;
        }

        com.ripple.infrasvc.service.dtos.request.SignUpUserRequest signUpUserRequest_ = new com.ripple.infrasvc.service.dtos.request.SignUpUserRequest();

        signUpUserRequest_.setName( signUpUserRequest.getName() );
        signUpUserRequest_.setEmail( signUpUserRequest.getEmail() );
        signUpUserRequest_.setMobileNo( signUpUserRequest.getMobileNo() );
        signUpUserRequest_.setPassword( signUpUserRequest.getPassword() );
        if ( signUpUserRequest.getRole() != null ) {
            signUpUserRequest_.setRole( new ArrayList<Role>( signUpUserRequest.getRole() ) );
        }

        return signUpUserRequest_;
    }

    @Override
    public com.ripple.infrasvc.service.dtos.request.SignInUserRequest apiServiceSignInUser(SignInUserRequest signInUserRequest) {
        if ( signInUserRequest == null ) {
            return null;
        }

        com.ripple.infrasvc.service.dtos.request.SignInUserRequest signInUserRequest_ = new com.ripple.infrasvc.service.dtos.request.SignInUserRequest();

        signInUserRequest_.setName( signInUserRequest.getName() );
        signInUserRequest_.setPassword( signInUserRequest.getPassword() );

        return signInUserRequest_;
    }

    @Override
    public com.ripple.infrasvc.service.dtos.request.CreateVMRequest apiServiceCreateVM(CreateVMRequest createVMRequest) {
        if ( createVMRequest == null ) {
            return null;
        }

        com.ripple.infrasvc.service.dtos.request.CreateVMRequest createVMRequest_ = new com.ripple.infrasvc.service.dtos.request.CreateVMRequest();

        createVMRequest_.setVmName( createVMRequest.getVmName() );
        createVMRequest_.setOperatingSystem( createVMRequest.getOperatingSystem() );
        if ( createVMRequest.getHardDisk() != null ) {
            createVMRequest_.setHardDisk( String.valueOf( createVMRequest.getHardDisk() ) );
        }
        if ( createVMRequest.getCpuCores() != null ) {
            createVMRequest_.setCpuCores( String.valueOf( createVMRequest.getCpuCores() ) );
        }
        if ( createVMRequest.getRam() != null ) {
            createVMRequest_.setRam( String.valueOf( createVMRequest.getRam() ) );
        }

        return createVMRequest_;
    }

    @Override
    public com.ripple.infrasvc.api.dtos.response.SignInUserResponse serviceApiSignInUser(SignInUserResponse signInUserResponse) {
        if ( signInUserResponse == null ) {
            return null;
        }

        com.ripple.infrasvc.api.dtos.response.SignInUserResponse signInUserResponse_ = new com.ripple.infrasvc.api.dtos.response.SignInUserResponse();

        signInUserResponse_.setToken( signInUserResponse.getToken() );

        return signInUserResponse_;
    }

    @Override
    public com.ripple.infrasvc.api.dtos.response.SignUpUserResponse serviceApiSignUpUser(SignUpUserResponse signUpUserResponse) {
        if ( signUpUserResponse == null ) {
            return null;
        }

        com.ripple.infrasvc.api.dtos.response.SignUpUserResponse signUpUserResponse_ = new com.ripple.infrasvc.api.dtos.response.SignUpUserResponse();

        signUpUserResponse_.setToken( signUpUserResponse.getToken() );

        return signUpUserResponse_;
    }

    @Override
    public List<com.ripple.infrasvc.api.dtos.response.VirtualMachine> serviceApiFetchAllVMForUser(List<VirtualMachine> virtualMachines) {
        if ( virtualMachines == null ) {
            return null;
        }

        List<com.ripple.infrasvc.api.dtos.response.VirtualMachine> list = new ArrayList<com.ripple.infrasvc.api.dtos.response.VirtualMachine>();
        for ( VirtualMachine virtualMachine : virtualMachines ) {
            list.add( serviceApiVM( virtualMachine ) );
        }

        return list;
    }

    @Override
    public com.ripple.infrasvc.api.dtos.response.VirtualMachine serviceApiVM(VirtualMachine virtualMachine) {
        if ( virtualMachine == null ) {
            return null;
        }

        com.ripple.infrasvc.api.dtos.response.VirtualMachine virtualMachine__ = new com.ripple.infrasvc.api.dtos.response.VirtualMachine();

        virtualMachine__.setVmName( virtualMachine.getVmName() );
        virtualMachine__.setOperatingSystem( virtualMachine.getOperatingSystem() );
        virtualMachine__.setRam( virtualMachine.getRam() );
        virtualMachine__.setCpuCores( virtualMachine.getCpuCores() );
        virtualMachine__.setHardDisk( virtualMachine.getHardDisk() );

        return virtualMachine__;
    }
}
