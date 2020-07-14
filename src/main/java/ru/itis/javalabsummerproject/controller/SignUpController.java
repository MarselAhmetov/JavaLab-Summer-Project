package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.dto.SignUpDto;
import ru.itis.javalabsummerproject.service.interfaces.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public ModelAndView getSignUpPage() {
        return new ModelAndView("signUp");
    }

    @PostMapping("/signUp")
    public ModelAndView signUp(SignUpDto signUpDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/signIn");
        signUpService.signUp(signUpDto);
        return modelAndView;
    }
}
