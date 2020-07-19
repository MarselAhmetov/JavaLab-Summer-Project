package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.model.Teacher;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.CompanyService;
import ru.itis.javalabsummerproject.service.interfaces.StudentService;
import ru.itis.javalabsummerproject.service.interfaces.TeacherService;
import ru.itis.javalabsummerproject.service.interfaces.UserService;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/student/{id}")
    public ModelAndView getStudent(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("principal", userDetails);
        User user = userService.getById(id);
        if (user != null) {
            Student student = studentService.getByUser(user);
            if (student != null) {
                modelAndView.addObject("student", student);
            } else {
                modelAndView.setViewName("404");
            }
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    @GetMapping("/teacher/{id}")
    public ModelAndView getTeacher(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("teacher");
        modelAndView.addObject("principal", userDetails);
        User user = userService.getById(id);
        if (user != null) {
            Teacher teacher = teacherService.getByUser(user);
            if (teacher != null) {
                modelAndView.addObject("teacher", teacher);
            } else {
                modelAndView.setViewName("404");
            }
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    @GetMapping("/company/{id}")
    public ModelAndView getCompany(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("company");
        modelAndView.addObject("principal", userDetails);
        User user = userService.getById(id);
        if (user != null) {
            Company company = companyService.getByUser(user);
            if (company != null) {
                modelAndView.addObject("company", company);
            } else {
                modelAndView.setViewName("404");
            }
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }
}
