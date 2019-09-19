package com.ripple.infrasvc.api.controller;

import com.ripple.infrasvc.api.dtos.request.CreateVMRequest;
import com.ripple.infrasvc.api.dtos.response.VirtualMachine;
import com.ripple.infrasvc.api.mapper.ApiServiceMapper;
import com.ripple.infrasvc.service.VMService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@Api(produces = "http")
@RestController
@RequestMapping("api/v1/vm")
public class VMController extends BaseController {

    @Autowired
    private ApiServiceMapper apiServiceMapper;

    @Autowired
    private VMService vmService;


    @ApiOperation(nickname = "create vm", value = "create vm", notes = "Create vm")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "VM has been created successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Expired or invalid JWT token"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Something went wrong"),
            @ApiResponse(code = HTTP_UNPROCESSABLE_ENTITY, message = "VM with name is already in use")})
    @RequestMapping(method = RequestMethod.POST, path = "/create", produces = MediaType.APPLICATION_JSON)
    public void createVM(@RequestBody @Valid CreateVMRequest request) {
        vmService.createVM(apiServiceMapper.apiServiceCreateVM(request));
    }

    @ApiOperation(nickname = "get all vm for particular user", value = "get all vm for particular user", notes = "get all vm for particular user")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "VM has been fetched successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Expired or invalid JWT token"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Something went wrong")})
    @RequestMapping(method = RequestMethod.GET, path = "/fetch/{username}", produces = MediaType.APPLICATION_JSON)
    public List<VirtualMachine> getAllVM(@PathVariable("username") @NotNull String userName) {

        return apiServiceMapper.serviceApiFetchAllVMForUser(vmService.fetchAllVM(userName));
    }

    @ApiOperation(nickname = "get top N vm for logged in user", value = "get top N vm for logged in user", notes = "get top N vm for logged in user")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "Top N VM has been fetched successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Expired or invalid JWT token"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Something went wrong")})
    @RequestMapping(method = RequestMethod.GET, path = "/fetch-current/{N}", produces = MediaType.APPLICATION_JSON)
    public List<VirtualMachine> getTopNVMForLoggedInUser(@PathVariable("N") @NotNull int n) {
        return apiServiceMapper.serviceApiFetchAllVMForUser(vmService.fetchTopNVMForLoggedInUser(n));
    }

    @ApiOperation(nickname = "get top N vm across user", value = "get top N vm across user", notes = "get top N vm across user")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "Top N VM across users has been fetched successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Expired or invalid JWT token"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Something went wrong")})
    @RequestMapping(method = RequestMethod.GET, path = "/fetch-all/{N}", produces = MediaType.APPLICATION_JSON)
    public List<VirtualMachine> getTopNVM(@PathVariable("N") @NotNull int n) {
        return apiServiceMapper.serviceApiFetchAllVMForUser(vmService.fetchTopNVM(n));
    }
}
