package com.tirage.examen.Repository;

import com.tirage.examen.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalleRep extends JpaRepository<Salle, Long> {}
