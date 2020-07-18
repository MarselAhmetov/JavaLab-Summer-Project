package ru.itis.javalabsummerproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSignUpDto extends UserDto {
    private String subject;
    private String firstName;
    private String middleName;
    private String lastName;
    private String sex;
}
