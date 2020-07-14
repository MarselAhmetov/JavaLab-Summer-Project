package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
