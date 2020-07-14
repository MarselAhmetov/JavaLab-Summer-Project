package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    Competence getByName(String name);
}
