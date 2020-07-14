package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.repositories.ResumeRepository;
import ru.itis.javalabsummerproject.service.interfaces.ResumeService;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume getById(Long id) {
        return resumeRepository.getOne(id);
    }

    @Override
    public void save(Resume resume) {
        resumeRepository.save(resume);
    }

    @Override
    public void delete(Resume resume) {
        resumeRepository.delete(resume);
    }

    @Override
    public List<Resume> getAllByUser(User user) {
        return resumeRepository.getAllByUser(user);
    }
}
