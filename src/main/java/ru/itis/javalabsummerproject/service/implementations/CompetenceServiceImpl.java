package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Competence;
import ru.itis.javalabsummerproject.repositories.CompetenceRepository;
import ru.itis.javalabsummerproject.service.interfaces.CompetenceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetenceServiceImpl implements CompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;

    @Override
    public Competence getById(Long id) {
        return competenceRepository.getOne(id);
    }

    @Override
    public void save(Competence competence) {
        competenceRepository.save(competence);
    }

    @Override
    public void delete(Competence competence) {
        competenceRepository.delete(competence);
    }

    @Override
    public Competence getByName(String name) {
        return competenceRepository.getByName(name);
    }

    /*
    * Создает из листа стрингов лист компетенций
    * Нужен когда нам присылают лист компетенций, часть из которых была выбрана из базы,
    * а часть написана вручную*/

    @Override
    public List<Competence> getCompetencesFromStringList(List<String> names) {
        List<Competence> competences = new ArrayList<>();
        Competence competence;
        for (String name : names) {
            if ((competence = competenceRepository.getByName(name)) == null) {
                competence = Competence.builder()
                        .name(name)
                        .build();
                competenceRepository.save(competence);
            }
            competences.add(competence);
        }
        return competences;
    }
}
