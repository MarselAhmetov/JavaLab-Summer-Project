package ru.itis.javalabsummerproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBirth;
    // TODO: 17.07.2020 Добавить age автоматически заполняется на основе dateOfBirth после вытягивания студента из базы
    private String firstName;
    private String sex;
    private String middleName;
    private String lastName;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private User user;
}
