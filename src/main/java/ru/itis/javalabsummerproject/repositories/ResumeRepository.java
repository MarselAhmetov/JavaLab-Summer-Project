package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.User;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> getAllByUser(User user);
}
