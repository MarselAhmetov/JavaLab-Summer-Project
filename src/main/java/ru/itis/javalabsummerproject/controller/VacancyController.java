package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.Vacancy;
import ru.itis.javalabsummerproject.model.dto.VacancyDto;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class VacancyController {


    @Autowired
    private UserService userService;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private CompetenceService competenceService;

    @GetMapping("/vacancies")
    public ModelAndView getPortfolioPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("vacancies");
        List<Vacancy> vacancies = vacancyService.findAll();
        modelAndView.addObject("vacancies", vacancies);
        modelAndView.addObject("principal", userDetails);
        return modelAndView;
    }

    @GetMapping("/vacancies/{userId}")
    public ModelAndView getUserResumesPage(@PathVariable Long userId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("vacancies");
        User user = userService.getById(userId);
        if (user != null) {
            List<Vacancy> vacancies = vacancyService.getAllByUser(user);
            modelAndView.addObject("user", user);
            modelAndView.addObject("vacancies", vacancies);
            modelAndView.addObject("principal", userDetails);
            if (userDetails != null && user.getId() == userDetails.getUser().getId()) {
                modelAndView.addObject("competencies", competenceService.findAll());
            }
        } else {
            modelAndView.setViewName("redirect:/vacancies");
        }
        return modelAndView;
    }

    @GetMapping("/vacancy/{vacancyId}")
    public ModelAndView getResumePage(@PathVariable Long vacancyId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("vacancy");
        Vacancy vacancy = vacancyService.getById(vacancyId);
        if (vacancy != null) {
            modelAndView.addObject("vacancy", vacancy);
            modelAndView.addObject("principal", userDetails);
        } else {
            modelAndView.setViewName("redirect:/vacancies");
        }
        return modelAndView;
    }


    // TODO: 19.07.2020 Доступно только компаниям
    @PostMapping("/vacancy/create")
    public ModelAndView newPortfolio(VacancyDto vacancyDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("redirect:/resumes/" + userDetails.getUser().getId());

        Vacancy vacancy = Vacancy.builder()
                .user(userDetails.getUser())
                .creationDate(LocalDateTime.now())
                .vacancyName(vacancyDto.getVacancyName())
                .requirements(vacancyDto.getRequirements())
                .description(vacancyDto.getDescription())
                .minSalary(vacancyDto.getMinSalary())
                .maxSalary(vacancyDto.getMaxSalary())
                .competencies(competenceService.getCompetencesFromStringList(vacancyDto.getCompetence()))
                .build();

        vacancyService.save(vacancy);
        return modelAndView;
    }
}
