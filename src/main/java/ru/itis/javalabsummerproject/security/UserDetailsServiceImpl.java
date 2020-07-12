package ru.itis.javalabsummerproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.repositories.UserRepository;

import java.util.Optional;

@Component("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        Optional<User> userOptional = userRepository.getByEmail(s);
        userOptional.ifPresent(userDetails::setUser);
        return userDetails;
    }
}
