package com.tirage.examen.Controller;

import com.tirage.examen.Service.UserService;
import com.tirage.examen.entities.Dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user")  UserRegistrationDto userDto,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        switch (userDto.getRole()) {
            case ADMIN:
                return "redirect:/admin_home";
            case RESPONSABLE_TIRAGE:
                return "redirect:/responsable_home";
            case ENSEIGNANT:
                return "redirect:/enseignant_home";
            default:
                return "redirect:/login";
        }
    }
}

