package ru.itis.javalabsummerproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vacancyName;
    private Integer minSalary;
    private Integer maxSalary;
    private LocalDateTime creationDate;
    private String requirements;
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Competence> competencies;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
