package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.model.User;

public interface StudentService {
    Student getById(Long id);
    void save(Student company);
    void delete(Student company);
    Student getByUser(User user);
}
