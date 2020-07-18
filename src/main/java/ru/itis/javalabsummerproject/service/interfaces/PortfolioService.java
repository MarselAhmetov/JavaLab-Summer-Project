package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Portfolio;
import ru.itis.javalabsummerproject.model.User;

import java.util.List;

public interface PortfolioService {
    Portfolio getById(Long id);
    void save(Portfolio portfolio);
    void delete(Portfolio portfolio);
    List<Portfolio> getAllByUser(User user);
    List<Portfolio> findAll();
}
