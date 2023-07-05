package com.wydnex.sapchws.auth.filters;


import com.wydnex.sapchws.auth.services.JWTService;
import com.wydnex.sapchws.auth.services.JWTServicesImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private JWTService jwtService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,  JWTService jwtService) {
        super(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JWTServicesImpl.HEADER_STRING);
        if (!requiereAuth(header)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = null;
        boolean isValidToken = jwtService.validate(header);
        if (isValidToken) {
            String username = jwtService.getUsername(header);
            Collection<? extends GrantedAuthority> rolesGranted = jwtService.getRoles(header);
            authenticationToken = new UsernamePasswordAuthenticationToken(username,null, rolesGranted);
        }

        /*autentica el usuario dentro del request*/
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    protected boolean requiereAuth(String header) {
        if (header == null || !header.startsWith(JWTServicesImpl.TOKEN_PREFIX)) {
            return false;
        }
        return true;
    }
}
