package ru.itis.javalabsummerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public ModelAndView getProfilePage() {
        ModelAndView modelAndView = new ModelAndView("profile");

        return modelAndView;
    }
}
