package com.yusuf.dans.service;


import com.yusuf.dans.Entity.UserAccess;
import com.yusuf.dans.repositories.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccessRepository userAccessRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccess userAccess = userAccessRepository.findByUsername(username);
        if (userAccess == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        if (!userAccess.isActive()) {
            throw new UsernameNotFoundException("This username is no longer able to be used");
        }
        return new org.springframework.security.core.userdetails.User(userAccess.getUsername(), userAccess.getPassword(),
                new ArrayList<>());
    }

    public UserAccess save(UserAccess userAccess) {
        userAccess.setPassword(bcryptEncoder.encode(userAccess.getPassword()));
        userAccess.setCreatedDate(new Date());
        userAccess.setActive(true);
        return userAccessRepository.save(userAccess);
    }


}
