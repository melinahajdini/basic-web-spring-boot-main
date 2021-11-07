package com.edon.basic.web.controller;

import com.edon.basic.web.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CookieController {
    @GetMapping("/login")
    public String getLogin(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(isUserLoggedIn(request.getCookies())){
            response.sendRedirect("/profile");
            return null;
        }
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute LoginModel loginModel, Model model,
                            HttpServletResponse response){
        String username = "admin";
        String password = "123456";

        if(username.equals(loginModel.getUsername()) &&
                password.equals(loginModel.getPassword())){
            // create cookie
            response.addCookie(new Cookie("logged_in", "true"));
            // redirect /profile
            try {
                response.sendRedirect("/profile");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        loginModel.setPassword("");
        model.addAttribute("loginModel", loginModel);
        model.addAttribute("error", "Username or Password is incorrect!");
        return "login";
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        if(this.isUserLoggedIn(request.getCookies())){
            // delete cookie
            Cookie logoutCookie = new Cookie("logged_in", "false");
            logoutCookie.setMaxAge(0);
            response.addCookie(logoutCookie);
        }

        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/profile")
    public String getProfile(HttpServletRequest request){
        if(this.isUserLoggedIn(request.getCookies())){
            return "profile";
        }
        return "login-error";
    }

    private boolean isUserLoggedIn(Cookie[] cookies){
        if(cookies == null){
            return false;
        }
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("logged_in") &&
            cookie.getValue().equals("true")){
                return true;
            }
        }
        return false;
    }
}
