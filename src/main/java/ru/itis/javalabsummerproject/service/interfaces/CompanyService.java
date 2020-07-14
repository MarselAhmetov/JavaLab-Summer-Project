package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Company;

public interface CompanyService {
    Company getById(Long id);
    void save(Company company);
    void delete(Company company);
}
