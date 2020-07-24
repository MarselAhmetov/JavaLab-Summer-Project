package ru.itis.javalabsummerproject.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.javalabsummerproject.model.Teacher;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.enumiration.Role;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeacherRepositoryIntegrationTest {

    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    public TeacherRepository teacherRepository;

    @Test
    public void whenGetByUser_thenReturnTeacher() {
        User user = User.builder()
                .username("username")
                .role(Role.STUDENT)
                .email("email")
                .password("password")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("firstName")
                .user(user)
                .build();

        entityManager.persist(user);
        entityManager.persist(teacher);

        Teacher found = teacherRepository.getByUser(user);

        assertThat(teacher.getFirstName()).isEqualTo(found.getFirstName());
    }
}
