package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.Vacancy;
import ru.itis.javalabsummerproject.repositories.VacancyRepository;
import ru.itis.javalabsummerproject.service.interfaces.VacancyService;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public Vacancy getById(Long id) {
        return vacancyRepository.getOne(id);
    }

    @Override
    public List<Vacancy> getAllByUser(User user) {
        return vacancyRepository.getAllByUser(user);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public void save(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    public void delete(Vacancy vacancy) {
        vacancyRepository.delete(vacancy);
    }
}
