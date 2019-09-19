package com.ripple.infrasvc.service;

import com.ripple.infrasvc.service.dtos.request.CreateVMRequest;
import com.ripple.infrasvc.service.dtos.response.VirtualMachine;

import java.util.List;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public interface VMService {

    void createVM(CreateVMRequest request);

    List<VirtualMachine> fetchAllVM(String userName);

    List<VirtualMachine> fetchTopNVMForLoggedInUser(int n);

    List<VirtualMachine> fetchTopNVM(int n);

}
