package ru.itis.javalabsummerproject.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.javalabsummerproject.model.Resume;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.enumiration.Role;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ResumeRepositoryIntegrationTest {

    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    public ResumeRepository resumeRepository;

    @Test
    public void whenGetAllByUser_thenReturnListOfResumes() {
        User user = User.builder()
                .username("username")
                .role(Role.STUDENT)
                .build();

        Resume resume1 = Resume.builder()
                .aboutMe("aboutMe")
                .desiredSalary(111)
                .resumeName("resume1")
                .user(user)
                .build();

        Resume resume2 = Resume.builder()
                .desiredSalary(111)
                .aboutMe("aboutMe")
                .resumeName("resume2")
                .portfolio(null)
                .user(user)
                .build();

        entityManager.persist(user);
        entityManager.persist(resume1);
        entityManager.persist(resume2);

        List<Resume> resumeList = resumeRepository.getAllByUser(user);

        assertThat(resumeList).contains(resume1, resume2);
    }
}
