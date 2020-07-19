package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy getById(Long id);
    List<Vacancy> getAllByUser(User user);
    List<Vacancy> findAll();
    void save(Vacancy vacancy);
    void delete(Vacancy vacancy);

}
