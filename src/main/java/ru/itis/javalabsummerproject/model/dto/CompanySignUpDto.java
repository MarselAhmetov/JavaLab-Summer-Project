package ru.itis.javalabsummerproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanySignUpDto extends UserDto {
    private String address;
    private String name;
    private String description;
}
