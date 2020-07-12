package ru.itis.javalabsummerproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    String name;
    String surname;
    String email;
    String password;
    Boolean teacher;
    Boolean student;
    Boolean employer;
}
