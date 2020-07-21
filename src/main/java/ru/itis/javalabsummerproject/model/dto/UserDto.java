package ru.itis.javalabsummerproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalabsummerproject.model.enumiration.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDto {
    private String username;
    private String password;
    private String email;
    private Role role;
}
