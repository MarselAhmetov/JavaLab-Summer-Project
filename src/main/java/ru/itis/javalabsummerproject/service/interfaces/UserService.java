package ru.itis.javalabsummerproject.service.interfaces;

import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.UserDto;

import java.util.List;

public interface UserService {
    User getByEmail(String email);
    User getById(Long id);
    void save(User user);
    void delete(User user);
    List<User> getAll();
    User getByUsername(String username);
    User update(UserDto userDto);
}
