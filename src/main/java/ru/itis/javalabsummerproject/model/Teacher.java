package ru.itis.javalabsummerproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String firstName;
    private String sex;
    private String middleName;
    private String lastName;

    @OneToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private User user;
}
