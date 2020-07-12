package ru.itis.javalabsummerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentsListController {
    @GetMapping("/student")
    public ModelAndView getVacanciesPage() {
        ModelAndView modelAndView = new ModelAndView("students");
        return modelAndView;
    }

    @GetMapping("/student/{id}")
    public ModelAndView getVacancyPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
