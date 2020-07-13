package ru.itis.javalabsummerproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table("RESUME")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;
    private String firstName;
    private String sex;
    private String middleName;
    private String lastName;
    private String vacancyName;
    private Integer desiredSalary;

    @ElementCollection
    private List<String> competences;
    private String aboutMe;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Portfolio portfolio;
//    private String skills;
    //    private Object image;


    @Override
    public Long getId() {
        return id;
    }
}
