package com.formation.microservice_inmueble.security;

import com.formation.microservice_inmueble.security.service.JpaUserDetailsService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
/*********** Codigo para gestionnar usuarios en memoria ****************************/
   /* @Bean
    public UserDetailsService userDetailsService(){

        /*UserDetails user1 = User.withUsername("jhon")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user1);

    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.httpBasic()
                .and()
                //.authorizeRequests().anyRequest().authenticated()
                //.authorizeRequests().anyRequest().hasAuthority("read")
                //.authorizeRequests().anyRequest().hasAnyAuthority("read", "create")
                //.authorizeRequests().mvcMatchers("/api/v1/inmueble/createInmueble").hasAnyAuthority("create")
                //.authorizeRequests().mvcMatchers("/api/v1/inmueble/**").hasAnyAuthority("read")
                //.authorizeRequests().mvcMatchers(HttpMethod.GET, "/api/v1/inmueble/**").hasAnyAuthority("read", "create")
                //.mvcMatchers(HttpMethod.POST, "/api/v1/inmueble/**").hasAnyAuthority("create")
                //.mvcMatchers("/api/v1/inmueble/hello").permitAll()
                .authorizeRequests().mvcMatchers("/api/v1/inmueble/createInmueble").authenticated()
                .anyRequest().permitAll()
                .and()
                .build();
    }
/**************************************************************************************/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //No usar este codigo en produccion solo en desarrollo
        //return new BCryptPasswordEncoder();
    }
}