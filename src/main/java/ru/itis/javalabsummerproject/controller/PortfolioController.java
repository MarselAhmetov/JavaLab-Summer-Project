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
import ru.itis.javalabsummerproject.security.UserDetailsImpl;
import ru.itis.javalabsummerproject.service.interfaces.PortfolioService;
import ru.itis.javalabsummerproject.service.interfaces.UserService;

import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    private UserService userService;
    @Autowired
    private PortfolioService portfolioService;


    @GetMapping("/portfolios")
    public ModelAndView getAllPortfoliosPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("portfolios");
        List<Portfolio> portfolios = portfolioService.findAll();
        modelAndView.addObject("portfolios", portfolios);
        modelAndView.addObject("principal", userDetails);
        return modelAndView;
    }

    @GetMapping("/portfolios/{userId}")
    public ModelAndView getUserPortfoliosPage(@PathVariable Long userId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("portfolios");
        User user = userService.getById(userId);
        if (user != null) {
            List<Portfolio> portfolios = portfolioService.getAllByUser(user);
            modelAndView.addObject("user", user);
            modelAndView.addObject("portfolios", portfolios);
            modelAndView.addObject("principal", userDetails);
        } else {
            modelAndView.setViewName("redirect:/portfolios");
        }
        return modelAndView;
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ModelAndView getPortfolioPage(@PathVariable Long portfolioId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("portfolio");
        Portfolio portfolio = portfolioService.getById(portfolioId);
        if (portfolio != null) {
            modelAndView.addObject("portfolio", portfolio);
            modelAndView.addObject("principal", userDetails);
        } else {
            modelAndView.setViewName("redirect:/profile/" + userDetails.getUser().getId());
        }
        return modelAndView;
    }

    @PostMapping("/portfolio/create")
    public ModelAndView newPortfolio(PortfolioDto portfolioDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView("redirect:/portfolios/" + userDetails.getUser().getId());

        Portfolio portfolio = Portfolio.builder()
                .topic(portfolioDto.getTopic())
                .content(portfolioDto.getContent())
                .user(userDetails.getUser())
                .build();

        portfolioService.save(portfolio);
        return modelAndView;
    }
}
