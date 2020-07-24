package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.ResumeDto;
import ru.itis.javalabsummerproject.model.enumiration.Role;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ResumeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private CompetenceService competenceService;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/resumes")
    public ModelAndView getPortfolioPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("resumes");
        List<Resume> resumes = resumeService.findAll();
        modelAndView.addObject("resumes", resumes);
        modelAndView.addObject("principal", userDetails);
        return modelAndView;
    }

    @GetMapping("/resumes/{userId}")
    public ModelAndView getUserResumesPage(@PathVariable Long userId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("resumes");
        User user = userService.getById(userId);
        if (user != null) {
            List<Resume> resumes = resumeService.getAllByUser(user);
            modelAndView.addObject("user", user);
            modelAndView.addObject("resumes", resumes);
            modelAndView.addObject("principal", userDetails);
            modelAndView.addObject("portfolios", portfolioService.getAllByUser(user));
        } else {
            modelAndView.setViewName("redirect:/resumes");
        }
        return modelAndView;
    }

    @GetMapping("/resume/{resumeId}")
    public ModelAndView getResumePage(@PathVariable Long resumeId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("resume");
        Resume resume = resumeService.getById(resumeId);
        if (resume != null) {
            if (userDetails.getUser().getRole().equals(Role.COMPANY)) {
                modelAndView.addObject("vacancies", vacancyService.getAllByUser(userDetails.getUser()));
            }
            modelAndView.addObject("resume", resume);
            modelAndView.addObject("principal", userDetails);
        } else {
            modelAndView.setViewName("redirect:/resumes");
        }
        return modelAndView;
    }

    // TODO: 19.07.2020 Доступно только студентам
    @PostMapping("/resume/create")
    public ModelAndView newPortfolio(ResumeDto resumeDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("redirect:/resumes/" + userDetails.getUser().getId());

        Resume resume = Resume.builder()
                .aboutMe(resumeDto.getAboutMe())
                .resumeName(resumeDto.getResumeName())
                .desiredSalary(resumeDto.getDesiredSalary())
                .competences(competenceService.getCompetencesFromStringList(resumeDto.getCompetences()))
                .portfolio(portfolioService.getById(resumeDto.getPortfolio()))
                .creationTime(LocalDateTime.now())
                .user(userDetails.getUser())
                .build();

        resumeService.save(resume);
        return modelAndView;
    }
}
