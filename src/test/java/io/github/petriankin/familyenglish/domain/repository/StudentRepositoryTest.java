package io.github.petriankin.familyenglish.domain.repository;

import io.github.petriankin.familyenglish.config.MongoTestContainer;
import io.github.petriankin.familyenglish.domain.models.Student;
import io.github.petriankin.familyenglish.utils.StudentDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

// TODO: 25.01.2021 dumb test, remove 
@Testcontainers
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Container
    public static MongoDBContainer mongoDBContainer = MongoTestContainer.getInstance();

    @Test
    void dumbTest() {
        Student entity = StudentDataProvider.getStudentEntity();
        Student saved = studentRepository.save(entity);
        List<Student> all = studentRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);

        studentRepository.delete(saved);
    }
}
