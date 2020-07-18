package ru.itis.javalabsummerproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentSignUpDto extends UserDto {
    private String dateOfBirth;
    private String firstName;
    private String middleName;
    private String lastName;
    private String sex;
}
