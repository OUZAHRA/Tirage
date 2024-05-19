package com.tirage.examen.Repository;

import com.tirage.examen.entities.RendezVous;
import com.tirage.examen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RendezVousRep extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByEnseignant(User enseignant);
}
