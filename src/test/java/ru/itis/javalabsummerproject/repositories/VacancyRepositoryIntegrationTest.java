package ru.itis.javalabsummerproject.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.Vacancy;

import javax.swing.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VacancyRepositoryIntegrationTest {

    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    public VacancyRepository vacancyRepository;

    @Test
    public void whenGetAllByUser_thenReturnListOfVacancies() {
        User user = User.builder()
                .username("username")
                .id(1L)
                .build();

        Vacancy vacancy1 = Vacancy.builder()
                .id(1L)
                .vacancyName("vacancy1")
                .user(user)
                .build();

        Vacancy vacancy2 = Vacancy.builder()
                .id(2L)
                .vacancyName("vacancy2")
                .user(user)
                .build();

        entityManager.merge(user);
        entityManager.merge(vacancy1);
        entityManager.merge(vacancy2);

        List<Vacancy> vacancyList = vacancyRepository.getAllByUser(user);

        assertThat(vacancyList).contains(vacancy1, vacancy2);


    }
}
