package io.github.petriankin.familyenglish.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.github.petriankin.familyenglish.api.dto.StudentDto;
import io.github.petriankin.familyenglish.config.MongoTestContainer;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class StudentComponentTest {

    @Container
    public static MongoDBContainer mongoDBContainer = MongoTestContainer.getInstance();
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void stop(){
        mongoDBContainer.stop();
    }

    @Test
    void whenCreateAndGetStudentIsCreated() {
        StudentDto studentDto = StudentDto.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        StudentDto result = performCreation(studentDto);

        Assertions.assertThat(result.getFirstName()).isEqualTo("John");


    }

    @Test
    @SneakyThrows
    void findAll() {
        StudentDto studentDto1 = StudentDto.builder()
                .firstName("John")
                .lastName("Doe")
                .build();
        StudentDto studentDto2 = StudentDto.builder()
                .firstName("Jane")
                .lastName("Smith")
                .build();

        performCreation(studentDto1);
        performCreation(studentDto2);

        String response = mockMvc.perform(
                get("/students"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        CollectionType javaType = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, StudentDto.class);
        List<StudentDto> result = objectMapper.readValue(response, javaType);

        Assertions.assertThat(result).hasSize(2);

    }

    @SneakyThrows
    private StudentDto performCreation(StudentDto studentDto) {
        String response = mockMvc.perform(
                post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDto)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        return objectMapper.readValue(response, StudentDto.class);
    }
}
