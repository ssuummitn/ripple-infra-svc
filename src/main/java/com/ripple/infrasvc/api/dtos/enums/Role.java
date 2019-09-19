package com.ripple.infrasvc.api.dtos.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    MASTER, NON_MASTER;

    public String getAuthority() {
        return name();
    }

}
