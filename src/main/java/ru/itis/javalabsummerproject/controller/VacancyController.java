package ru.itis.javalabsummerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VacancyController {

    @GetMapping("/vacancy")
    public ModelAndView getVacanciesPage() {
        ModelAndView modelAndView = new ModelAndView("vacancies");
        return modelAndView;
    }

    @GetMapping("/vacancy/{id}")
    public ModelAndView getVacancyPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
