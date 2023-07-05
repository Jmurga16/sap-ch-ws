package com.wydnex.sapchws;


import com.wydnex.sapchws.auth.filters.JWTAuthenticationFilter;
import com.wydnex.sapchws.auth.filters.JwtAuthorizationFilter;
import com.wydnex.sapchws.auth.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

/* EnableGlobalMethodSecurity se habilita la seguridad de forma de anotaciones*/
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurtityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public static BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    ;

    @Qualifier("jWTServicesImpl")
    private JWTService jwtService;

    @Autowired
    public SpringSecurtityConfig(
            JWTService jwtService
    ) {

        this.jwtService = jwtService;
    }

    /*se anota Autowired para poder uitlizar  AuthenticationManagerBuilder */
    @Autowired
    public void configureGLobal(AuthenticationManagerBuilder builder) throws Exception {


        User.UserBuilder userBuilder = User.builder().passwordEncoder(pass -> encoder().encode(pass));
        builder.inMemoryAuthentication()
                .withUser(userBuilder.username("admin").password("12345").roles("ADMIN", "USER"));


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors()
                .configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .authorizeRequests()

                .antMatchers("/api/presupuestos/**").permitAll()
                .antMatchers("/api/presupuestos/util/v1.0.0/listarComboSecure").permitAll()
                .anyRequest().authenticated()
                .and()
                /*se agrega los filtros */

                .addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService)) /*se agrega la forma  de autenticacion*/
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtService))
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
    }
}
