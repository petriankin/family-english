package io.github.petriankin.familyenglish.domain.repository;

import io.github.petriankin.familyenglish.domain.models.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static java.lang.String.format;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
@ContextConfiguration(initializers = StudentRepositoryTest.Initializer.class)
class StudentRepositoryTest {

    @Container
    public static MongoDBContainer mongoContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0"));
    @Autowired
    protected ApplicationContext context;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void dumbTest() {
        studentRepository.save(new Student());
        List<Student> all = studentRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext,
                    format("spring.data.mongodb.uri=mongodb://%s:%s/test-db", mongoContainer.getContainerIpAddress(),
                            mongoContainer.getMappedPort(27017)));
        }
    }
}
