package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Competence;

import java.util.List;

public interface CompetenceService {
    Competence getById(Long id);
    void save(Competence competence);
    void delete(Competence competence);
    Competence getByName(String name);
    List<Competence> getCompetencesFromStringList(List<String> names);
}
