package com.edon.basic.web.controller;

import com.edon.basic.web.model.FitnessUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FitnessController {

    @GetMapping("/addfitnessuser")
    public String getFitness(Model model) {
        model.addAttribute("fitnessUser", new FitnessUser());
        return "FitnessApp";

    }
    @PostMapping("/viewfitnessusers")
    public String createUser(@ModelAttribute FitnessUser fitnessUser, Model model) {
        model.addAttribute("fitnessUser", fitnessUser);
        return "ViewFitnessUsers";
    }
}
