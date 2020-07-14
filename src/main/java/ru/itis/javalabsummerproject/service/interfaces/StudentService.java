package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Student;

public interface StudentService {
    Student getById(Long id);
    void save(Student company);
    void delete(Student company);
}
