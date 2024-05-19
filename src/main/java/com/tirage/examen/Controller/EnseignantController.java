package com.tirage.examen.Controller;
import com.tirage.examen.Service.SalleService;
import com.tirage.examen.entities.Examen;
import com.tirage.examen.entities.RendezVous;
import com.tirage.examen.Service.RendezVousService;
import com.tirage.examen.Service.UserService;
import com.tirage.examen.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/enseignant")
public class EnseignantController {
    @Autowired
    private RendezVousService rendezVousService;

    @Autowired
    private UserService userService;

    private SalleService salleService;

    @GetMapping("/create_rendezvous")
    public String showCreateRendezVousForm(Model model) {
        model.addAttribute("rendezvous", new RendezVous());
        model.addAttribute("salles", salleService.getAllSalles());
        return "create_rendezvous";
    }

    @PostMapping("/create_rendezvous")
    public String createRendezVous(@ModelAttribute("rendezvous") RendezVous rendezVous,
                                   @RequestParam("copies") int copies,
                                   @RequestParam("subject") Examen subject) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User enseignant = (User) auth.getPrincipal();
        rendezVous.setEnseignant(enseignant);
        rendezVous.setCopies(copies);
        rendezVous.setSubject(subject);
        rendezVousService.saveRendezVous(rendezVous);
        return "redirect:/enseignant/all_rendezvous";
    }

    @GetMapping("/rendezvous")
    public String getRendezVous(Model model) {
        // Récupérer l'objet Authentication à partir du contexte de sécurité
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Obtenir le nom d'utilisateur de l'utilisateur connecté
        String username = authentication.getName();

        // Trouver l'utilisateur par nom d'utilisateur
        User enseignant = userService.findUserByUsername(username);
                model.addAttribute("rendezvous", rendezVousService.findRendezVousByEnseignant(enseignant));
        model.addAttribute("examens", rendezVousService.findAllExamens());
        model.addAttribute("salles", rendezVousService.findAllSalles());
        return "rendezvous";
    }

    @PostMapping("/rendezvous")
    public String saveRendezVous(@ModelAttribute RendezVous rendezVous) {
        rendezVousService.saveRendezVous(rendezVous);
        return "redirect:/enseignant/rendezvous";

    }
    @GetMapping("/all_rendezvous")
    public String getAllRendezVous(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User enseignant = (User) auth.getPrincipal();

        List<RendezVous> rendezvousList = rendezVousService.findRendezVousByEnseignant(enseignant);

        model.addAttribute("rendezvousList", rendezvousList);

        return "all_rendezvous";
    }
    @GetMapping("/edit_rendezvous/{id}")
    public String showEditRendezVousForm(@PathVariable Long id, Model model) {
        RendezVous rendezVous = rendezVousService.getRendezVousById(id);
        model.addAttribute("rendezvous", rendezVous);
        model.addAttribute("salles", salleService.getAllSalles());
        return "edit_rendezvous";
    }

    @PostMapping("/edit_rendezvous")
    public String editRendezVous(@ModelAttribute("rendezvous") RendezVous rendezVous,
                                 @RequestParam("copies") int copies,
                                 @RequestParam("subject") Examen subject) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User enseignant = (User) auth.getPrincipal();
        rendezVous.setEnseignant(enseignant);
        rendezVous.setCopies(copies);
        rendezVous.setSubject(subject);
        rendezVousService.saveRendezVous(rendezVous);
        return "redirect:/enseignant/all_rendezvous";
    }

    @PostMapping("/delete_rendezvous")
    public String deleteRendezVous(@RequestParam Long id) {
        rendezVousService.deleteRendezVousById(id);
        return "redirect:/enseignant/all_rendezvous";
    }
}
