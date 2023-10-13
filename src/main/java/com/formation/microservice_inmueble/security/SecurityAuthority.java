package com.formation.microservice_inmueble.security;

import com.formation.microservice_inmueble.security.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {
    private final Authority authorities;

    public SecurityAuthority(Authority authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getAuthority() {
        return authorities.getName();
    }
}
