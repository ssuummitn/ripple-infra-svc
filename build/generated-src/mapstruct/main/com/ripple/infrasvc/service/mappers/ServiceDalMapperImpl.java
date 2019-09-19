package com.ripple.infrasvc.service.mappers;

import com.ripple.infrasvc.api.dtos.enums.Role;
import com.ripple.infrasvc.dal.model.User;
import com.ripple.infrasvc.dal.model.VirtualMachine;
import com.ripple.infrasvc.service.dtos.request.CreateVMRequest;
import com.ripple.infrasvc.service.dtos.request.SignUpUserRequest;
import com.ripple.infrasvc.service.dtos.response.SignInUserResponse;
import com.ripple.infrasvc.service.dtos.response.SignUpUserResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-20T01:03:17+0530",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class ServiceDalMapperImpl extends ServiceDalMapper {

    @Override
    public SignUpUserResponse dalToServiceSignUpUserResponse(String token) {
        if ( token == null ) {
            return null;
        }

        SignUpUserResponse signUpUserResponse = new SignUpUserResponse();

        signUpUserResponse.setToken( token );

        return signUpUserResponse;
    }

    @Override
    public SignInUserResponse dalToServiceSignInUserResponse(String token) {
        if ( token == null ) {
            return null;
        }

        SignInUserResponse signInUserResponse = new SignInUserResponse();

        signInUserResponse.setToken( token );

        return signInUserResponse;
    }

    @Override
    public List<com.ripple.infrasvc.service.dtos.response.VirtualMachine> dalToServiceFetchAllVMResponse(List<VirtualMachine> token) {
        if ( token == null ) {
            return null;
        }

        List<com.ripple.infrasvc.service.dtos.response.VirtualMachine> list = new ArrayList<com.ripple.infrasvc.service.dtos.response.VirtualMachine>();
        for ( VirtualMachine virtualMachine : token ) {
            list.add( dalToServiceVM( virtualMachine ) );
        }

        return list;
    }

    @Override
    public User serviceToDalSignUpUserRequest(SignUpUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setName( request.getName() );
        user.setEmail( request.getEmail() );
        user.setPassword( request.getPassword() );
        if ( request.getRole() != null ) {
            user.setRole( new ArrayList<Role>( request.getRole() ) );
        }
        user.setMobileNo( request.getMobileNo() );

        return user;
    }

    @Override
    public VirtualMachine serviceToDalCreateVMRequest(CreateVMRequest request, User user) {
        if ( request == null && user == null ) {
            return null;
        }

        VirtualMachine virtualMachine = new VirtualMachine();

        if ( request != null ) {
            virtualMachine.setVmName( request.getVmName() );
            virtualMachine.setOperatingSystem( request.getOperatingSystem() );
            if ( request.getRam() != null ) {
                virtualMachine.setRam( Integer.parseInt( request.getRam() ) );
            }
            if ( request.getHardDisk() != null ) {
                virtualMachine.setHardDisk( Integer.parseInt( request.getHardDisk() ) );
            }
            if ( request.getCpuCores() != null ) {
                virtualMachine.setCpuCores( Integer.parseInt( request.getCpuCores() ) );
            }
        }
        if ( user != null ) {
            virtualMachine.setUser( user );
            virtualMachine.setId( user.getId() );
            virtualMachine.setCreatedAt( user.getCreatedAt() );
            virtualMachine.setUpdatedAt( user.getUpdatedAt() );
        }

        return virtualMachine;
    }

    @Override
    public com.ripple.infrasvc.service.dtos.response.VirtualMachine dalToServiceVM(VirtualMachine token) {
        if ( token == null ) {
            return null;
        }

        com.ripple.infrasvc.service.dtos.response.VirtualMachine virtualMachine_ = new com.ripple.infrasvc.service.dtos.response.VirtualMachine();

        virtualMachine_.setVmName( token.getVmName() );
        virtualMachine_.setOperatingSystem( token.getOperatingSystem() );
        virtualMachine_.setRam( token.getRam() );
        virtualMachine_.setCpuCores( token.getCpuCores() );
        virtualMachine_.setHardDisk( token.getHardDisk() );

        return virtualMachine_;
    }
}
