package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Portfolio;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.repositories.PortfolioRepository;
import ru.itis.javalabsummerproject.service.interfaces.PortfolioService;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public Portfolio getById(Long id) {
        return portfolioRepository.getOne(id);
    }

    @Override
    public void save(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    @Override
    public void delete(Portfolio portfolio) {
        portfolioRepository.delete(portfolio);
    }

    @Override
    public List<Portfolio> getAllByUser(User user) {
        return portfolioRepository.getAllByUser(user);
    }

    @Override
    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }
}
