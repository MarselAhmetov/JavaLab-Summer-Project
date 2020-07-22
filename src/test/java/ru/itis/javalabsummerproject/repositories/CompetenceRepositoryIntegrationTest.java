package ru.itis.javalabsummerproject.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.javalabsummerproject.model.Competence;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CompetenceRepositoryIntegrationTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Test
    public void whenGetByName_thenReturnCompetence() {
        Competence competence = Competence.builder()
                .name("html")
                .build();

        entityManager.persist(competence);
        entityManager.flush();

        Competence found = competenceRepository.getByName("html");

        assertThat(found.getName()).isEqualTo(competence.getName());
    }

}

