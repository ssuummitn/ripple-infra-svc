package com.ripple.infrasvc.api.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@ApiModel(description = "Request for VM creation")
public class CreateVMRequest {
    @ApiModelProperty(name = "name", required = true)
    @NotBlank
    @JsonProperty(value = "name", required = true)
    private String vmName;

    @ApiModelProperty(name = "operating_system", required = true)
    @NotBlank
    @JsonProperty(value = "operating_system", required = true)
    private String operatingSystem;

    @ApiModelProperty(name = "hard_disk", required = true)
    @Min(1)
    @JsonProperty(value = "hard_disk", required = true)
    private Integer hardDisk;

    @ApiModelProperty(name = "cpu_cores", required = true)
    @Min(1)
    @JsonProperty(value = "cpu_cores", required = true)
    private Integer cpuCores;

    @ApiModelProperty(name = "ram", required = true)
    @Min(1)
    @JsonProperty(value = "ram", required = true)
    private Integer ram;

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String name) {
        this.vmName = name;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Integer getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(Integer hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }
}
