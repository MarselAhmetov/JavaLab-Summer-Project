package ru.itis.javalabsummerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
    @GetMapping("/signUp")
    public ModelAndView getSignUpPage() {
        ModelAndView modelAndView = new ModelAndView("ftlh/signUp");
        return modelAndView;
    }

    @PostMapping("/signUp")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
