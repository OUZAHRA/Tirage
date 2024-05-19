package com.tirage.examen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Custom logic for handling errors
        return "error"; // Assurez-vous d'avoir un fichier error.html dans templates
    }

    public String getErrorPath() {
        return "/error";
    }
}

