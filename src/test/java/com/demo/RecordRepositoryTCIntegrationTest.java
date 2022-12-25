package com.demo;

import com.demo.model.RedCarpet;
import com.demo.repo.RecordRepository;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {RecordRepositoryTCIntegrationTest.Initializer.class})
public class RecordRepositoryTCIntegrationTest {

    @Autowired
    protected RecordRepository recordRepository;


    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
      .withDatabaseName("postgres")
      .withUsername("postgres")
      .withPassword("postgres");

    static class Initializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
              "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
              "spring.datasource.username=" + postgreSQLContainer.getUsername(),
              "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
     public void test_dd(){
        RedCarpet redCarpet = new RedCarpet();
        redCarpet.setAddress("Indore");
        redCarpet.setPincode(452010);
        redCarpet.setState("MP");
        recordRepository.save(redCarpet);
        assertThat(recordRepository.findAll()!=null);
    }
}