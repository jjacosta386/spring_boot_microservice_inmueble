package com.formation.microservice_inmueble.security.service;

import com.formation.microservice_inmueble.security.SecurityUser;
import com.formation.microservice_inmueble.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        var u = userRepository.findUsersByUsername(username);
        return u.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
    }
}
