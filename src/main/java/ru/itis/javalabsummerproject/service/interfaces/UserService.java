package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.User;

import java.util.List;

public interface UserService {
    User getByEmail(String email);
    void save(User user);
    void delete(User user);
    List<User> getAll();
}
