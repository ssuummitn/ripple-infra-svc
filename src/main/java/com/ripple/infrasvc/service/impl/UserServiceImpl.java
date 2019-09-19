package com.ripple.infrasvc.service.impl;

import com.ripple.infrasvc.api.dtos.enums.Role;
import com.ripple.infrasvc.auth.JwtTokenProvider;
import com.ripple.infrasvc.dal.model.User;
import com.ripple.infrasvc.dal.repository.UserRepository;
import com.ripple.infrasvc.exception.CustomException;
import com.ripple.infrasvc.service.UserService;
import com.ripple.infrasvc.service.dtos.request.SignInUserRequest;
import com.ripple.infrasvc.service.dtos.request.SignUpUserRequest;
import com.ripple.infrasvc.service.dtos.response.SignInUserResponse;
import com.ripple.infrasvc.service.dtos.response.SignUpUserResponse;
import com.ripple.infrasvc.service.mappers.ServiceDalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ServiceDalMapper serviceDalMapper;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    @Transactional
    public SignUpUserResponse signUp(SignUpUserRequest user) {
        if (!userRepository.existsByName(user.getName())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(serviceDalMapper.serviceToDalSignUpUserRequest(user));
            return serviceDalMapper.dalToServiceSignUpUserResponse(
                    jwtTokenProvider.createToken(user.getName(), user.getRole()));
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public SignInUserResponse signIn(SignInUserRequest user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
            return serviceDalMapper.dalToServiceSignInUserResponse(
                    jwtTokenProvider.createToken(user.getName(), userRepository.findByName(user.getName()).getRole()));
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    @Transactional
    public void deleteUser(String user) {
        User userDetails = userRepository.findByName(user);
        if (userDetails == null) {
            throw new CustomException("User is not registered", HttpStatus.NOT_FOUND);
        }
        Authentication authentication = jwtTokenProvider.getAuthentication();
        if (authentication.getAuthorities().contains(Role.MASTER) || authentication.getName().equals(user)) {
            userRepository.deleteByName(userDetails.getName());
        } else {
            throw new CustomException("User is not authorized", HttpStatus.UNAUTHORIZED);
        }
    }
}
