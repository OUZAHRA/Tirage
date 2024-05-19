package com.tirage.examen.config;

import com.tirage.examen.Repository.UserRep;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {

private UserRep userRep;

@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    com.tirage.examen.entities.User user = userRep.findByEmail(email);
    if (user == null) {
        throw new UsernameNotFoundException("Utilisateur non trouvé");
    }
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
}
}