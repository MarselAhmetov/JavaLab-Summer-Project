package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.repositories.ResumeRepository;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentsListController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ResumeRepository resumeRepository;

    @GetMapping("/students")
    public ModelAndView getVacanciesPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("students");

        Map<Student, List<Resume>> studentListMap = new HashMap<>();

        List<Student> studentList =  studentService.findAll();
        for(Student student: studentList) {
            List<Resume> resumeList = resumeRepository.getAllByUser(student.getUser());
            studentListMap.put(student, resumeList);
        }

        modelAndView.addObject("studentsMap", studentListMap);
        modelAndView.addObject("principal", userDetails);
        return modelAndView;
    }

}
