package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.model.User;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getByUser(User user);
}
