package com.guild.backend.controller;

import com.guild.backend.entity.Job;
import com.guild.backend.repo.JobRepo;
import com.guild.backend.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.guild.backend.entity.User;
import com.guild.backend.repo.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersLoginController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JobRepo jobRepo;


    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
            return "login";
        }

        if (logout != null){
            model.addAttribute("message", "You have been logged out successfully.");
            return "login";
        }

        if (securityService.isAuthenticated()) {
            return "redirect:/profile";
        }

        return "login";
    }



    @GetMapping("/profile")
    public String welcome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByLogin(auth.getName());
        System.out.println(user);
//        List<Job> jobs = jobRepo.findByAdventurer_idAndDate_acceptedIsNotNull(user.getId());
//        System.out.println(jobs);
        List<Integer> date = List.of(1,2,3,4,5,6,7,8,9,10,11,12);
        model.addAttribute("data", date);
        model.addAttribute("user", user);
        return "profileDemo";
    }
}