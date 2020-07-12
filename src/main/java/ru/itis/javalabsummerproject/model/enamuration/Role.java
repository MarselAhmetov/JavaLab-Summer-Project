package ru.itis.javalabsummerproject.model.enamuration;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    EMPLOYER, STUDENT, TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
