package ru.itis.javalabsummerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Invite;
import ru.itis.javalabsummerproject.model.Student;

import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    List<Invite> getAllByCompany(Company company);
    List<Invite> getAllByStudent(Student student);
}
