package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Teacher;

public interface TeacherService {
    Teacher getById(Long id);
    void save(Teacher company);
    void delete(Teacher company);
}
