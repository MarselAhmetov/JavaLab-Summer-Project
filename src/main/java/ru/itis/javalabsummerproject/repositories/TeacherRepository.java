package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Teacher;
import ru.itis.javalabsummerproject.model.User;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher getByUser(User user);
}
