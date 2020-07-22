package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.Response;
import ru.itis.javalabsummerproject.model.dto.ResponseDto;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.*;

import java.util.List;

@Controller
public class ResponseController {
    @Autowired
    private ResponseService responseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private UserService userService;

    // TODO: 19.07.2020 Доступно только студентам и компаниям
    @GetMapping("/responses")
    public ModelAndView getResponsesPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("responses");
        List<Response> responses = null;
        switch (userDetails.getUser().getRole()) {
            case STUDENT:
                responses = responseService.getAllByStudent(studentService.getByUser(userDetails.getUser()));
                break;
            case COMPANY:
                responses = responseService.getAllByCompany(companyService.getByUser(userDetails.getUser()));
                break;
        }
        modelAndView.addObject("responses", responses);
        modelAndView.addObject("principal", userDetails);
        return modelAndView;
    }

    // TODO: 19.07.2020 Доступно только студентам
    @PostMapping("/response/create")
    public ModelAndView newResponse(ResponseDto responseDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("redirect:/invites/" + userDetails.getUser().getId());

        Response response = Response.builder()
                .text(responseDto.getText())
                .student(studentService.getByUser(userDetails.getUser()))
                .company(companyService.getByUser(userService.getById(responseDto.getUserId())))
                .resume(resumeService.getById(responseDto.getResumeId()))
                .vacancy(vacancyService.getById(responseDto.getVacancyId()))
                .build();

        responseService.save(response);
        return modelAndView;
    }
}
