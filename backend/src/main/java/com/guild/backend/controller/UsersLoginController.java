package com.guild.backend.controller;

import com.guild.backend.entity.Job;
import com.guild.backend.repo.JobRepo;
import com.guild.backend.service.SecurityService;

import com.guild.backend.service.UserService;
import com.guild.backend.web.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import com.guild.backend.entity.User;
import com.guild.backend.repo.UserRepo;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/profile";
        }

        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm,bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User user = userForm;

        userService.create(userForm);

        securityService.autoLogin(userForm.getLogin(), userForm.getPasswordConfirm());

        return "redirect:/profile";
    }
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
        List<Integer> date = List.of(0,0,0,0,0,0,1,2,0,0,0,0);
        List<Integer> jobs = new ArrayList<Integer>();

        for (long i = 1; i < 13; i++) {
            System.out.println(user.getId());
            System.out.println(i);
            Long j = user.getId();
            Long k = i;
            String value = i + "";
//            List<Integer> temp = jobRepo.findByAdventurerAndDate(j, k);
//            jobs.add(temp.size());
        }

        System.out.println(jobs);

        model.addAttribute("data", date);
        model.addAttribute("user", user);
        return "profileDemo";
    }


}