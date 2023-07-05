package com.wydnex.sapchws.auth.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wydnex.sapchws.auth.model.Usuario;
import com.wydnex.sapchws.auth.services.JWTService;
import com.wydnex.sapchws.auth.services.JWTServicesImpl;

import static com.wydnex.sapchws.auth.config.PathsAuth.*;
import static com.wydnex.sapchws.utils.config.PathsUtil.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    //generando clave secreta dinamicamente


    private AuthenticationManager authenticationManage;
    private JWTService jwtService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManage, JWTService jwtService) {
        this.authenticationManage = authenticationManage;
        this.jwtService = jwtService;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(ROOT_API + OATUH + VERSION + LOGIN, "POST"));
    }

    /*autentiacion que no necesita un formulario*/
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        String username = this.obtainUsername(request);
        username = username != null ? username.trim() : null;
        String password = "12345";
        if (username == null) {
            Usuario usuario;
            try {
                usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
                username = usuario.getUsername().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManage.authenticate(authenticationToken);
    }

    /*se ejecuta cuando el logeo fue correcto*/
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = jwtService.create(authResult);
        response.addHeader("Authorization", JWTServicesImpl.TOKEN_PREFIX + token);
        Map<String, Object> body = new HashMap<>();
        body.put("token", token);
        body.put("user", authResult.getPrincipal());
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");


    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "error en la autenticacion");
        body.put("error", failed.getMessage());
        response.setStatus(401);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType("application/json");
    }
}
