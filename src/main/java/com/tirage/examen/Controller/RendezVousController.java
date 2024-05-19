package com.tirage.examen.Controller;

import com.tirage.examen.entities.RendezVous;
import com.tirage.examen.Service.RendezVousService;
import com.tirage.examen.Service.UserService;
import com.tirage.examen.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/RendezVous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;
    @Autowired
    private UserService userService;

    @GetMapping("/enseignant/rendezvous/new")
    public String showCreateRendezVousForm(Model model) {
        model.addAttribute("rendezvous", new RendezVous());
        return "create_rendezvous";
    }

    @PostMapping("/enseignant/rendezvous")
    public String createRendezVous(@ModelAttribute("rendezvous") RendezVous rendezVous, Principal principal) {
        User enseignant = userService.findUserByUsername(principal.getName());
        rendezVous.setEnseignant(enseignant);
        rendezVousService.saveRendezVous(rendezVous);
        return "redirect:/enseignant/rendezvous";
    }


    @GetMapping("/enseignant/rendezvous/edit/{id}")
    public String showEditRendezVousForm(@PathVariable("id") Long id, Model model) {
        RendezVous rendezVous = rendezVousService.findById(id);
        model.addAttribute("rendezvous", rendezVous);
        return "edit_rendezvous";
    }

    @PostMapping("/enseignant/rendezvous/update/{id}")
    public String updateRendezVous(@PathVariable("id") Long id, @ModelAttribute("rendezvous") RendezVous rendezVous) {
        rendezVousService.updateRendezVous(id, rendezVous);
        return "redirect:/enseignant/rendezvous";
    }

    @GetMapping("/responsable/rendezvous")
    public String getAllRendezVous(Model model) {
        List<RendezVous> rendezVousList = rendezVousService.findAll();
        model.addAttribute("rendezvousList", rendezVousList);
        return "all_rendezvous";
    }


}
