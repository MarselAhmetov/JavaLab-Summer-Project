package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.repositories.StudentRepository;
import ru.itis.javalabsummerproject.service.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student company) {
        studentRepository.save(company);
    }

    @Override
    public void delete(Student company) {
        studentRepository.delete(company);
    }

    @Override
    public Student getByUser(User user) {
        return studentRepository.getByUser(user);
    }
}
