package com.tirage.examen.config;

import com.tirage.examen.Repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRep userRep;


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        com.tirage.examen.entities.User user = userRep.findByEmail(userEmail);
        if(user != null){
            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(String.valueOf(user.getRole()))
                    .build();
        }else{
            throw new UsernameNotFoundException(userEmail);
        }


    }
}
