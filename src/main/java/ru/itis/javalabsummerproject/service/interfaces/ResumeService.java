package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.User;

import java.util.List;

public interface ResumeService {
    Resume getById(Long id);
    void save(Resume resume);
    void delete(Resume resume);
    List<Resume> getAllByUser(User user);
    List<Resume> findAll();
}
