package com.sv.autokart.services;

import com.sv.autokart.models.User;
import com.sv.autokart.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);
        User user = userOptional.orElseThrow(()->new UsernameNotFoundException("No user found with email: "+email));
        return new org.springframework.security.core.userdetails.User
                (user.getEmail(),
                        user.getPassword(),
                        user.isEnabled(),
                        true,true,true,
                        getAuthorities("User"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role){
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
