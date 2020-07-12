package ru.itis.javalabsummerproject.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.repositories.UserRepository;
import ru.itis.javalabsummerproject.service.interfaces.UserService;

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
    public void save(User user) {
        userRepository.save(user);
    }
}
