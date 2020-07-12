package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.User;

public interface UserService {
    User getByEmail(String email);
    void save(User user);
}
