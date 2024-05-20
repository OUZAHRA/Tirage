package com.tirage.examen.config;

import java.io.IOException;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = "Email/Mot de paase est inccorect.";
        if (exception instanceof BadCredentialsException) {
            errorMessage = "Invalid username or password";
        } else if (exception instanceof DisabledException) {
            errorMessage = "Account is disabled";
        } else if (exception instanceof AccountExpiredException) {
            errorMessage = "Account has expired";
        }
        // Set the error message as a request attribute
        request.setAttribute("loginError", errorMessage);
        // Forward to the login page
        request.getRequestDispatcher("/Login").forward(request, response);
    }


}
