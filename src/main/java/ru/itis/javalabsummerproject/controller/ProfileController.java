package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.UserDto;
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




    /*
    * Профиль любого пользователя с отображением информации о нем в зависимости от его роли
    * Если пользователь и принципал совпадают то появляется возможность редактировать информацию
    * */

    @GetMapping("/profile/{id}")
    public ModelAndView getProfilePage(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("profile");
        User user = userService.getById(id);
        modelAndView.addObject("user", user);
        switch (user.getRole()) {
            case STUDENT:
                modelAndView.addObject(studentService.getByUser(user));
                break;
            case TEACHER:
                modelAndView.addObject(teacherService.getByUser(user));
                break;
            case EMPLOYER:
                modelAndView.addObject(companyService.getByUser(user));
                break;
        }
        modelAndView.addObject("currentUser", userDetails.getUser());
        return modelAndView;
    }


    /*
    * Редактирование информации о пользователе (Без дополнительной информации о студенте, компании и тд)
    * */
    @PostMapping("/profile/edit")
    public ModelAndView editUser(UserDto userDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("redirect:/profile");
        User user = userService.update(userDto);
        if (user != null) {
            userDetails.setUser(user);
        }
        return modelAndView;
    }
}
