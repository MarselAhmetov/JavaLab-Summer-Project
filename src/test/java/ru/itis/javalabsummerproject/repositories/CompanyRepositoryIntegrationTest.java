package ru.itis.javalabsummerproject.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.javalabsummerproject.model.Company;
import ru.itis.javalabsummerproject.model.User;
import ru.itis.javalabsummerproject.model.enumiration.Role;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)

public class CompanyRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void whenGetByUser_thenReturnCompany() {
        User user = User.builder()
                .email("email")
                .password("password")
                .role(Role.COMPANY)
                .username("username")
                .id(1L)
                .build();

        Company company = Company.builder()
                .address("address")
                .description("description")
                .id(1L)
                .user(user)
                .build();

        entityManager.merge(company);

        Company found = companyRepository.getByUser(user);

        assertThat(found.getAddress()).isEqualTo(company.getAddress());
    }
}
