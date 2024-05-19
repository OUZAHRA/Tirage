package com.tirage.examen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Time time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User enseignant;
    @ManyToOne
    private Examen examen;

    @ManyToOne
    private Salle salle;
    private int copies;

    public void setSubject(Examen subject) {
        this.examen = subject;
    }

public void setCopies(int copies) {

    }


}
