package ru.itis.javalabsummerproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime inviteTime;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    private Resume resume;

    @ManyToOne(fetch = FetchType.EAGER)
    private Vacancy vacancy;
}
