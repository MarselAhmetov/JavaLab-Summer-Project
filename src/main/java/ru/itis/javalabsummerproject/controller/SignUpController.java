package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.dto.CompanySignUpDto;
import ru.itis.javalabsummerproject.model.dto.StudentSignUpDto;
import ru.itis.javalabsummerproject.model.dto.TeacherSignUpDto;
import ru.itis.javalabsummerproject.model.enamuration.Role;
import ru.itis.javalabsummerproject.service.interfaces.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp/{role}")
    public ModelAndView getSignUpPage(@PathVariable String role) {
        System.out.println(role);
        switch (role) {
            case "student":
                return new ModelAndView("StudentSignUp");
            case "teacher":
                return new ModelAndView("TeacherSignUp");
            case "company":
                return new ModelAndView("CompanySignUp");
            default:
                return new ModelAndView("redirect:/signUp/student");
        }

    }

    @PostMapping("/signUp/student")
    public ModelAndView signUpStudent(StudentSignUpDto signUpDto) {
        System.out.println(signUpDto.toString());
        ModelAndView modelAndView = new ModelAndView("redirect:/signIn");
        signUpDto.setRole(Role.STUDENT);
        signUpService.signUp(signUpDto);
        return modelAndView;
    }

    @PostMapping("/signUp/teacher")
    public ModelAndView signUpTeacher(TeacherSignUpDto signUpDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/signIn");
        signUpDto.setRole(Role.TEACHER);
        signUpService.signUp(signUpDto);
        return modelAndView;
    }

    @PostMapping("/signUp/company")
    public ModelAndView signUpCompany(CompanySignUpDto signUpDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/signIn");
        signUpDto.setRole(Role.COMPANY);
        signUpService.signUp(signUpDto);
        return modelAndView;
    }

}
