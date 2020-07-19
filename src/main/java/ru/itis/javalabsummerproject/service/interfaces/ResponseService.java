package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Invite;
import ru.itis.javalabsummerproject.model.Response;
import ru.itis.javalabsummerproject.model.Student;

import java.util.List;

public interface ResponseService {
    Response getById(Long id);
    void save(Response response);
    void delete(Response response);
    List<Response> getAllByCompany(Company company);
    List<Response> getAllByStudent(Student student);
    List<Response> findAll();
}
