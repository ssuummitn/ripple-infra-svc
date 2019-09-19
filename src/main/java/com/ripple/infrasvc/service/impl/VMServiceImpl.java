package com.ripple.infrasvc.service.impl;

import com.ripple.infrasvc.auth.JwtTokenProvider;
import com.ripple.infrasvc.dal.model.User;
import com.ripple.infrasvc.dal.repository.UserRepository;
import com.ripple.infrasvc.dal.repository.VMRepository;
import com.ripple.infrasvc.exception.CustomException;
import com.ripple.infrasvc.service.VMService;
import com.ripple.infrasvc.service.dtos.request.CreateVMRequest;
import com.ripple.infrasvc.service.dtos.response.VirtualMachine;
import com.ripple.infrasvc.service.mappers.ServiceDalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@Service
public class VMServiceImpl implements VMService {

    @Autowired
    private VMRepository vmRepository;

    @Autowired
    private ServiceDalMapper serviceDalMapper;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public void createVM(CreateVMRequest request) {
        if (!vmRepository.existsByvmName(request.getVmName())) {
            User user = userRepository.findByName(jwtTokenProvider.getAuthentication().getName());
            vmRepository.save(serviceDalMapper.serviceToDalCreateVMRequest(request, user));
        } else {
            throw new CustomException("VM with the name is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<VirtualMachine> fetchAllVM(String userName) {
        return serviceDalMapper.dalToServiceFetchAllVMResponse(
                vmRepository.findAllByUser(userRepository.findByName(userName)));
    }

    @Override
    public List<VirtualMachine> fetchTopNVMForLoggedInUser(int n) {
        User user = userRepository.findByName(jwtTokenProvider.getAuthentication().getName());
        Pageable topN = PageRequest.of(0, n);
        return serviceDalMapper.dalToServiceFetchAllVMResponse(
                vmRepository.findByUserOrderByHardDiskDesc(user, topN));
    }

    @Override
    public List<VirtualMachine> fetchTopNVM(int n) {
        Pageable topN = PageRequest.of(0, n);
        return serviceDalMapper.dalToServiceFetchAllVMResponse(
                vmRepository.findAllByOrderByHardDiskDesc(topN));
    }
}
