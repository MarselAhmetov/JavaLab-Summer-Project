package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.Portfolio;
import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.PortfolioDto;
import ru.itis.javalabsummerproject.model.dto.ResumeDto;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.CompetenceService;
import ru.itis.javalabsummerproject.service.interfaces.PortfolioService;
import ru.itis.javalabsummerproject.service.interfaces.ResumeService;
import ru.itis.javalabsummerproject.service.interfaces.UserService;

@Controller
public class ResumeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private CompetenceService competenceService;

    @GetMapping("/resumes")
    public ModelAndView getPortfolioPage(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getById(id);
        if (user != null) {
            modelAndView.addObject("resumes", resumeService.getAllByUser(user));
        }
        modelAndView.setViewName("redirect:/profile/" + id);
        return modelAndView;
    }

    @PostMapping("/resume/create")
    public ModelAndView newPortfolio(ResumeDto resumeDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("/portfolios/" + userDetails.getUser().getId());

        Resume resume = Resume.builder()
                .aboutMe(resumeDto.getAboutMe())
                .resumeName(resumeDto.getResumeName())
                .desiredSalary(resumeDto.getDesiredSalary())
                .competences(competenceService.getCompetencesFromStringList(resumeDto.getCompetences()))
                .user(userDetails.getUser())
                .build();

        resumeService.save(resume);
        return modelAndView;
    }
}
