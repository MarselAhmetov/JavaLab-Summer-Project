package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Teacher;
import ru.itis.javalabsummerproject.model.User;

public interface TeacherService {
    Teacher getById(Long id);
    void save(Teacher company);
    void delete(Teacher company);
    Teacher getByUser(User user);
}
