package com.ripple.infrasvc.service.mappers;


import com.ripple.infrasvc.dal.model.User;
import com.ripple.infrasvc.dal.model.VirtualMachine;
import com.ripple.infrasvc.service.dtos.request.CreateVMRequest;
import com.ripple.infrasvc.service.dtos.request.SignUpUserRequest;
import com.ripple.infrasvc.service.dtos.response.SignInUserResponse;
import com.ripple.infrasvc.service.dtos.response.SignUpUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@Mapper
public abstract class ServiceDalMapper {
    public abstract SignUpUserResponse dalToServiceSignUpUserResponse(String token);

    public abstract SignInUserResponse dalToServiceSignInUserResponse(String token);

    public abstract List<com.ripple.infrasvc.service.dtos.response.VirtualMachine> dalToServiceFetchAllVMResponse(
            List<VirtualMachine> token);

    public abstract User serviceToDalSignUpUserRequest(SignUpUserRequest request);

    @Mappings({@Mapping(target = "user", source = "user")})
    public abstract VirtualMachine serviceToDalCreateVMRequest(CreateVMRequest request, User user);

    public abstract com.ripple.infrasvc.service.dtos.response.VirtualMachine dalToServiceVM(
            VirtualMachine token);


}
