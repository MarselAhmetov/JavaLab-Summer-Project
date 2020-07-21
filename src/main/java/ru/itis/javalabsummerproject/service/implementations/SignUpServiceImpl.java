package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.model.Teacher;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.CompanySignUpDto;
import ru.itis.javalabsummerproject.model.dto.StudentSignUpDto;
import ru.itis.javalabsummerproject.model.dto.TeacherSignUpDto;
import ru.itis.javalabsummerproject.model.dto.UserDto;
import ru.itis.javalabsummerproject.service.interfaces.*;

import java.time.LocalDate;

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
    public void signUp(UserDto signUpDto) {

        User user = User.builder()
                .username(signUpDto.getUsername())
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .role(signUpDto.getRole())
                .build();

        //userService.save(user);

        switch (signUpDto.getRole()) {
            case STUDENT:
                StudentSignUpDto studentDto = (StudentSignUpDto) signUpDto;
                Student student = Student.builder()
                        .dateOfBirth(LocalDate.parse(studentDto.getDateOfBirth()))
                        .firstName(studentDto.getFirstName())
                        .middleName(studentDto.getMiddleName())
                        .lastName(studentDto.getLastName())
                        .sex(studentDto.getSex())
                        .user(user)
                        .build();
                studentService.save(student);
                break;
            case TEACHER:
                TeacherSignUpDto teacherDto = (TeacherSignUpDto) signUpDto;
                Teacher teacher = Teacher.builder()
                        .subject(teacherDto.getSubject())
                        .firstName(teacherDto.getFirstName())
                        .middleName(teacherDto.getMiddleName())
                        .lastName(teacherDto.getLastName())
                        .sex(teacherDto.getSex())
                        .user(user)
                        .build();
                teacherService.save(teacher);
                break;
            case COMPANY:
                CompanySignUpDto companyDto = (CompanySignUpDto) signUpDto;
                Company company = Company.builder()
                        .address(companyDto.getAddress())
                        .name(companyDto.getName())
                        .description(companyDto.getDescription())
                        .user(user)
                        .build();
                companyService.save(company);
                break;
        }
    }
}
