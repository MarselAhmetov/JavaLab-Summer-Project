package ru.itis.javalabsummerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public ModelAndView getSignInPage() {
        ModelAndView modelAndView = new ModelAndView("ftlh/signIn");
        return modelAndView;
    }

    @PostMapping("/signIn")
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
