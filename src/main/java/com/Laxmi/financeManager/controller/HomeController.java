package com.Laxmi.financeManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        // Return the Thymeleaf login template
        return "login";  // This should map to src/main/resources/templates/login.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        // Return the Thymeleaf dashboard template
        return "dashboard";  // This should map to src/main/resources/templates/dashboard.html
    }

    @GetMapping("/home")
    public String home() {
        // Return the Thymeleaf home page template
        return "home";  // This should map to src/main/resources/templates/home.html
    }
}