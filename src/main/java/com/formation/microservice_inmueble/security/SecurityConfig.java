package com.formation.microservice_inmueble.security;

import com.formation.microservice_inmueble.security.service.JpaUserDetailsService;
import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
/*********** Codigo para gestionnar usuarios en memoria ****************************/
        /*UserDetails user1 = User.withUsername("jhon")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user1);*/
/************************************************************************************/
    return new JpaUserDetailsService();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //No usar este codigo en produccion
        //return new BCryptPasswordEncoder();
    }
}