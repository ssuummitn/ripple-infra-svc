package com.ripple.infrasvc.service.dtos.response;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public class VirtualMachine {

    private String vmName;
    private String operatingSystem;
    private Integer ram;
    private Integer cpuCores;
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
