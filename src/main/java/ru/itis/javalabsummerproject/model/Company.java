package ru.itis.javalabsummerproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table("COMPANY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", unique = true, nullable = false)
    private Long id;

    private String address;
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Vacancy> vacancies;
}
