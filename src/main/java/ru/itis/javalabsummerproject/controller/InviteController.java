package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.Invite;
import ru.itis.javalabsummerproject.model.dto.InviteDto;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.*;

import java.util.List;

@Controller
public class InviteController {
    @Autowired
    private InviteService inviteService;
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

    @GetMapping("/invites")
    public ModelAndView getInvitesPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("invites");
        List<Invite> invites = null;
        switch (userDetails.getUser().getRole()) {
            case STUDENT:
                invites = inviteService.getAllByStudent(studentService.getByUser(userDetails.getUser()));
                break;
            case COMPANY:
                invites = inviteService.getAllByCompany(companyService.getByUser(userDetails.getUser()));
                break;
        }
        modelAndView.addObject("invites", invites);
        modelAndView.addObject("principal", userDetails);
        return modelAndView;
    }

    // TODO: 19.07.2020 Доступно только компаниям
    @PostMapping("/invite/create")
    public ModelAndView newInvitation(InviteDto inviteDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("redirect:/invites/" + userDetails.getUser().getId());

        Invite invite = Invite.builder()
                .text(inviteDto.getText())
                .student(studentService.getByUser(userService.getById(inviteDto.getUserId())))
                .company(companyService.getByUser(userDetails.getUser()))
                .resume(resumeService.getById(inviteDto.getResumeId()))
                .vacancy(vacancyService.getById(inviteDto.getVacancyId()))
                .build();

        inviteService.save(invite);
        return modelAndView;
    }
}
