package ru.itis.javalabsummerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalabsummerproject.model.Portfolio;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.PortfolioDto;
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.PortfolioService;
import ru.itis.javalabsummerproject.service.interfaces.UserService;

@Controller
public class PortfolioController {

    @Autowired
    private UserService userService;
    @Autowired
    private PortfolioService portfolioService;

    /*
    * Получение листа контроллеров для любого студента
    * Просмотреть портфолио можно будет здесь же в виде большого модального окна
    * */

    @GetMapping("/portfolios/{id}")
    public ModelAndView getPortfolioPage(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getById(id);
        if (user != null) {
            modelAndView.addObject("portfolios", portfolioService.getAllByUser(user));
        }
        modelAndView.setViewName("redirect:/profile/" + id);
        return modelAndView;
    }

    @PostMapping("/portfolio/create")
    public ModelAndView newPortfolio(PortfolioDto portfolioDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("/portfolios/" + userDetails.getUser().getId());

        Portfolio portfolio = Portfolio.builder()
                .topic(portfolioDto.getTopic())
                .content(portfolioDto.getContent())
                .user(userDetails.getUser())
                .isConfirmed(false)
                .build();

        portfolioService.save(portfolio);
        return modelAndView;
    }
}
