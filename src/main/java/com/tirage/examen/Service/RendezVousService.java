package com.tirage.examen.Service;

import com.tirage.examen.Repository.ExamenRep;
import com.tirage.examen.Repository.SalleRep;
import com.tirage.examen.entities.Examen;
import com.tirage.examen.entities.RendezVous;
import com.tirage.examen.entities.Salle;
import com.tirage.examen.entities.User;
import com.tirage.examen.Repository.RendezVousRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RendezVousService {
    @Autowired
    private RendezVousRep rendezVousRep;

    @Autowired
    private ExamenRep examenRep;

    @Autowired
    private SalleRep salleRep;

    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRep.save(rendezVous);
    }

    public List<RendezVous> findRendezVousByEnseignant(User enseignant) {
        return rendezVousRep.findByEnseignant(enseignant);
    }

    public List<RendezVous> findAllRendezVous() {
        return rendezVousRep.findAll();
    }

    public RendezVous findById(Long id){return null;}

    public void updateRendezVous(Long id, RendezVous rendezVous){}

    public List<RendezVous> findAll(){return null;}

    public void deleteRendezVous(Long id) {
        rendezVousRep.deleteById(id);
    }

    public List<Examen> findAllExamens() {
        return examenRep.findAll();
    }

    public List<Salle> findAllSalles() {
        return salleRep.findAll();
    }

    public RendezVous getRendezVousById(Long id) {
        return null;
    }

    public void deleteRendezVousById(Long id) {
    }
}
