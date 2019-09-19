package com.ripple.infrasvc.dal.model;

import com.ripple.infrasvc.api.dtos.enums.Role;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> role;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    Set<VirtualMachine> virtualMachines = new HashSet<>();
    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @NotNull
    @Column(name = "mobile_no", unique = true)
    private String mobileNo;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Set<VirtualMachine> getVirtualMachines() {
        return virtualMachines;
    }

    public void setVirtualMachines(Set<VirtualMachine> virtualMachines) {
        this.virtualMachines = virtualMachines;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
