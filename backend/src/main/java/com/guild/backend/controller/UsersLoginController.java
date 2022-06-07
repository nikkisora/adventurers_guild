package com.guild.backend.controller;

import com.guild.backend.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.guild.backend.entity.User;
import com.guild.backend.repo.UserRepo;

@Controller
public class UsersLoginController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping("/profile")
    public String welcome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByLogin(auth.getName());
        System.out.println(user);
        model.addAttribute("user", user);
        return "profile";
    }
}