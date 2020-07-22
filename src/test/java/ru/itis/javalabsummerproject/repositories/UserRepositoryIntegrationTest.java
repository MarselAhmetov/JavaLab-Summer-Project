package ru.itis.javalabsummerproject.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.javalabsummerproject.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    public UserRepository userRepository;

    @Test
    public void whenGetByEmail_thenReturnUser() {
        String email = "email";

        User user = User.builder()
                .id(1L)
                .email(email)
                .username("username")
                .build();

        entityManager.merge(user);

        User found = userRepository.getByEmail(email);

        assertThat(user.getUsername()).isEqualTo(found.getUsername());

    }

    @Test
    public void whenGetByUsername_thenReturnUser() {
        String username = "username";

        User user = User.builder()
                .id(1L)
                .email("email")
                .username(username)
                .build();

        entityManager.merge(user);

        User found = userRepository.getByUsername(username);

        assertThat(user.getUsername()).isEqualTo(found.getUsername());
    }
}
