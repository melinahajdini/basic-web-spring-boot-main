package com.edon.basic.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/page")
    public String page(@RequestParam("p") String page, @RequestParam("password") String password){
        if(password.equals("1234")){
            return page;
        }
            return "error";
    }

    @GetMapping("/kalkulo")
    public String kalkulo(@RequestParam("a") String a, @RequestParam("b") String b, Model model){
        double shuma;
        try{
            shuma = Double.parseDouble(a) + Double.parseDouble(b);
        }
        catch(Exception e){
            return "error";
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("shuma", shuma);
        return "kalkulo";
    }



    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
