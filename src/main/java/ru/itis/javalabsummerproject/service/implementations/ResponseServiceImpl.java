package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Response;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.repositories.ResponseRepository;
import ru.itis.javalabsummerproject.service.interfaces.ResponseService;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public Response getById(Long id) {
        return responseRepository.getOne(id);
    }

    @Override
    public void save(Response response) {
        responseRepository.save(response);
    }

    @Override
    public void delete(Response response) {
        responseRepository.delete(response);
    }

    @Override
    public List<Response> getAllByCompany(Company company) {
        return responseRepository.getAllByCompany(company);
    }

    @Override
    public List<Response> getAllByStudent(Student student) {
        return responseRepository.getAllByStudent(student);
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }
}
