package com.supmti.ecommerceappspringboot.security;

import com.supmti.ecommerceappspringboot.Exceptions.AuthException;
import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Repositories.UserRepository;
import com.supmti.ecommerceappspringboot.Services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Primary
@AllArgsConstructor
@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByEmail(username);
        if(user==null)
            throw new AuthException("user not fount");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE-USER")));
    }
}
