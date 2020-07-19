package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Response;
import ru.itis.javalabsummerproject.model.Student;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> getAllByCompany(Company company);
    List<Response> getAllByStudent(Student student);
}
