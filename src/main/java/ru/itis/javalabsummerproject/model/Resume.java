package ru.itis.javalabsummerproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resumeName;
    private Integer desiredSalary;
    private String aboutMe;
    private LocalDateTime creationTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private List<Competence> competences;

    @OneToOne(fetch = FetchType.EAGER)
    private Portfolio portfolio;

}
