package com.tirage.examen.Service;

import com.tirage.examen.Repository.UserRep;
import com.tirage.examen.entities.Dto.UserRegistrationDto;
import com.tirage.examen.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRep userRep;
    private PasswordEncoder passwordEncoder;
    private UserRegistrationDto userDto;

    public User saveUser(User user) {
        return userRep.save(user);
    }

    public User findUserByUsername(String email) {
        return userRep.findByEmail(email);
    }

    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    public List<User> findAll(){return null;}
    public User findById (Long id){return  null;}
    public void updateUser(User user){
    }
    public void deleteUser(Long id){}

    public void save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRole(userDto.getRole());
        userRep.save(user);
    }

    public void deleteUserById(Long userId) {
    }
}
