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
    private String name;
    private String surname;
    private String email;
    private String password;
    private Boolean teacher;
    private Boolean student;
    private Boolean employer;
}
