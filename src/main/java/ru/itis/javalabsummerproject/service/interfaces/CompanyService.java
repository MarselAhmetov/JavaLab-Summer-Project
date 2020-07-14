package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.User;

public interface CompanyService {
    Company getById(Long id);
    void save(Company company);
    void delete(Company company);
    Company getByUser(User user);
}
