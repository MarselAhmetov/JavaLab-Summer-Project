package ru.itis.javalabsummerproject.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.javalabsummerproject.model.Portfolio;
import ru.itis.javalabsummerproject.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PortfolioRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Test
    public void whenGetAllByUser_thenReturnListOfPortfolios() {
        User user = User.builder()
                .username("username")
                .build();

        Portfolio portfolio1 = Portfolio.builder()
                .user(user)
                .build();

        Portfolio portfolio2 = Portfolio.builder()
                .user(user)
                .build();

        entityManager.persist(user);
        entityManager.persist(portfolio1);
        entityManager.persist(portfolio2);

        List<Portfolio> portfolioList = portfolioRepository.getAllByUser(user);

        assertThat(portfolioList).contains(portfolio1, portfolio2);
    }
}
