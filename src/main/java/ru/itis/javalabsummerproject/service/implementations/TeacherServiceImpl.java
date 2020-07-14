package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Teacher;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.repositories.TeacherRepository;
import ru.itis.javalabsummerproject.service.interfaces.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public void save(Teacher company) {
        teacherRepository.save(company);
    }

    @Override
    public void delete(Teacher company) {
        teacherRepository.delete(company);
    }

    @Override
    public Teacher getByUser(User user) {
        return teacherRepository.getByUser(user);
    }
}
