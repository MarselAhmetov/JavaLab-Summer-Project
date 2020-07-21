package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.service.interfaces.StudentService;

@Controller
public class StudentsListController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ModelAndView getVacanciesPage() {
        ModelAndView modelAndView = new ModelAndView("students");
        return modelAndView;
    }

}
