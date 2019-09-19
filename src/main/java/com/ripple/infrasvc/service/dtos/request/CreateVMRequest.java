package com.ripple.infrasvc.service.dtos.request;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public class CreateVMRequest {

    private String vmName;
    private String operatingSystem;
    private String hardDisk;
    private String cpuCores;
    private String ram;

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

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(String cpuCores) {
        this.cpuCores = cpuCores;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
