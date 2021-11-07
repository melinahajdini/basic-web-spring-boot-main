package com.edon.basic.web.controller;

import com.edon.basic.web.model.Telefoni;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelefoniController {
    @GetMapping("add-telefon")
    public String addTelefon(Model model) {
        Telefoni telefoni = new Telefoni();
        telefoni.setOs("windows");
        model.addAttribute("telefon", telefoni);
        return "newTelefon";
    }
}
