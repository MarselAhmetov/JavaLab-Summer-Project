package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.model.Teacher;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.SignUpDto;
import ru.itis.javalabsummerproject.model.enamuration.Role;
import ru.itis.javalabsummerproject.service.interfaces.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Override
    public void signUp(SignUpDto signUpDto) {

        User user = User.builder()
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .build();

        List<Role> roles = new ArrayList<>(3);

        if (signUpDto.getEmployer() != null) {
            Company company = Company.builder()
                    .user(user)
                    .build();
            roles.add(Role.EMPLOYER);
            userService.save(user);
            companyService.save(company);
        }
        if (signUpDto.getStudent() != null) {
            Student student = Student.builder()
                    .user(user)
                    .build();
            roles.add(Role.STUDENT);
            userService.save(user);
            studentService.save(student);
        }
        if (signUpDto.getTeacher()!= null) {
            Teacher teacher = Teacher.builder()
                    .user(user)
                    .build();
            roles.add(Role.TEACHER);
            userService.save(user);
            teacherService.save(teacher);
        }

        user.setRoles(roles);
    }
}
