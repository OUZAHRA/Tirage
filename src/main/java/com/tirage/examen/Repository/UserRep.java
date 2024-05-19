package com.tirage.examen.Repository;

import com.tirage.examen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {
    //User findByEmail(String email);

    User findByEmail(String email);

}
