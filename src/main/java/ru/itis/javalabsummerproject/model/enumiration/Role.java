package ru.itis.javalabsummerproject.model.enamuration;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    COMPANY, STUDENT, TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
