package ru.itis.javalabsummerproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyDto {
    private String vacancyName;
    private Integer minSalary;
    private Integer maxSalary;
    private String requirements;
    private String description;
    private List<String> competence;
}
