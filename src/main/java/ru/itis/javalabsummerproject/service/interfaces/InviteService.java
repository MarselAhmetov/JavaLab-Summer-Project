package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Invite;
import ru.itis.javalabsummerproject.model.Student;

import java.util.List;

public interface InviteService {
    Invite getById(Long id);
    void save(Invite invite);
    void delete(Invite invite);
    List<Invite> getAllByCompany(Company company);
    List<Invite> getAllByStudent(Student student);
    List<Invite> findAll();
}
