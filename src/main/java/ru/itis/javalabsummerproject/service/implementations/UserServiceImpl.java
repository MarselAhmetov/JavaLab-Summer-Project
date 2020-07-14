package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.dto.UserDto;
import ru.itis.javalabsummerproject.repositories.UserRepository;
import ru.itis.javalabsummerproject.service.interfaces.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getByEmail(String email) {
        Optional<User> userOptional = userRepository.getByEmail(email);
        return userOptional.orElse(null);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username).orElse(null);
    }

    @Override
    public User update(UserDto userDto) {
        User user = userRepository.getByUsername(userDto.getUsername()).orElse(null);
        if (user != null) {
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return user;
        }
        return null;
    }
}
