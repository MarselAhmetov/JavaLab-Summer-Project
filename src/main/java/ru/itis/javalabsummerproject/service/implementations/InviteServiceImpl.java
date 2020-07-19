package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.Invite;
import ru.itis.javalabsummerproject.model.Student;
import ru.itis.javalabsummerproject.repositories.InviteRepository;
import ru.itis.javalabsummerproject.service.interfaces.InviteService;

import java.util.List;

@Service
public class InviteServiceImpl implements InviteService {
    @Autowired
    private InviteRepository inviteRepository;

    @Override
    public Invite getById(Long id) {
        return inviteRepository.getOne(id);
    }

    @Override
    public void save(Invite invite) {
        inviteRepository.save(invite);
    }

    @Override
    public void delete(Invite invite) {
        inviteRepository.delete(invite);
    }

    @Override
    public List<Invite> getAllByCompany(Company company) {
        return inviteRepository.getAllByCompany(company);
    }

    @Override
    public List<Invite> getAllByStudent(Student student) {
        return inviteRepository.getAllByStudent(student);
    }

    @Override
    public List<Invite> findAll() {
        return inviteRepository.findAll();
    }
}
