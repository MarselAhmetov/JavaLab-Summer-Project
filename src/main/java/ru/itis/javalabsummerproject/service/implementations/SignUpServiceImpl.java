package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.SignUpDto;
import ru.itis.javalabsummerproject.model.enamuration.Role;
import ru.itis.javalabsummerproject.service.interfaces.SignUpService;
import ru.itis.javalabsummerproject.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpDto signUpDto) {

        User user = User.builder()
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .build();

        List<Role> roles = new ArrayList<>(3);

        if (signUpDto.getEmployer() != null) {
            roles.add(Role.EMPLOYER);
        }
        if (signUpDto.getStudent() != null) {
            roles.add(Role.STUDENT);
        }
        if (signUpDto.getTeacher()!= null) {
            roles.add(Role.TEACHER);
        }

        user.setRoles(roles);

        userService.save(user);
    }
}
