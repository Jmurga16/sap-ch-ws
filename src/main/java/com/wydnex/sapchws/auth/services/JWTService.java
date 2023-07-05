package com.wydnex.sapchws.auth.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;

public interface JWTService<T> {
    String create(Authentication authentication) throws IOException;

    boolean validate(String token);

    T getClaims(String token);

    String getUsername(String token);

    Collection<? extends GrantedAuthority> getRoles(String token) throws IOException;

    String resolve(String token);

}
