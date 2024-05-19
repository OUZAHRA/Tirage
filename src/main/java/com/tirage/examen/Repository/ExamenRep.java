package com.tirage.examen.Repository;

import com.tirage.examen.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExamenRep extends JpaRepository<Examen, Long> {}
