package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.repositories.CompanyRepository;
import ru.itis.javalabsummerproject.service.interfaces.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company getById(Long id) {
        return companyRepository.getOne(id);
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public Company getByUser(User user) {
        return companyRepository.getByUser(user);
    }
}
