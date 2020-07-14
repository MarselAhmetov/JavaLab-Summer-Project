package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.User;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company getByUser(User user);
}
