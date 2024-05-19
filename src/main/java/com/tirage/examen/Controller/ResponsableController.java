package com.tirage.examen.Controller;
import com.tirage.examen.Service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/responsable")
public class ResponsableController {
    @Autowired
    private RendezVousService rendezVousService;

    @GetMapping("/rendezvous")
    public String getAllRendezVous(Model model) {
        model.addAttribute("rendezvous", rendezVousService.findAllRendezVous());
        return "rendezvous";
    }
}
