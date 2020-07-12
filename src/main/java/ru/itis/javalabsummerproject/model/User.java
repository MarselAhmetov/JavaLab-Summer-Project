package ru.itis.javalabsummerproject.model;

import org.springframework.security.core.GrantedAuthority;
import ru.itis.javalabsummerproject.model.enamuration.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
}
