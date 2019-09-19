package com.ripple.infrasvc.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@ApiModel(description = "Response of VM")
public class VirtualMachine {

    @JsonProperty(value = "name")
    private String vmName;
    @JsonProperty(value = "operating_system")
    private String operatingSystem;
    @JsonProperty(value = "ram")
    private Integer ram;
    @JsonProperty(value = "cpu_cores")
    private Integer cpuCores;
    @JsonProperty(value = "hard_disk")
    private Integer hardDisk;

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

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Integer getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(Integer hardDisk) {
        this.hardDisk = hardDisk;
    }
}
