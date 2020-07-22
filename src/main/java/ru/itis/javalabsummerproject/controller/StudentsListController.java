package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.StudentService;

@Controller
public class StudentsListController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ModelAndView getVacanciesPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", studentService.findAll());
        modelAndView.addObject("principal", userDetails);
        return modelAndView;
    }

}
