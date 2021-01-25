package io.github.petriankin.familyenglish.domain.mapper;

import io.github.petriankin.familyenglish.api.dto.StudentDto;
import io.github.petriankin.familyenglish.domain.models.Student;
import io.github.petriankin.familyenglish.utils.StudentDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(StudentMapper.class);
    }

    @Test
    void whetMapToEntityMapsCorrectly() {
        StudentDto studentDto = StudentDataProvider.getStudentDto();

        Student student = mapper.toEntity(studentDto);

        Student expected = StudentDataProvider.getStudentEntity();

        Assertions.assertThat(student).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void whenMapToDtoMapsCorrectly() {
        Student entity = StudentDataProvider.getStudentEntity();

        StudentDto studentDto = mapper.toDto(entity);

        StudentDto expected = StudentDataProvider.getStudentDto();

        Assertions.assertThat(studentDto).usingRecursiveComparison().isEqualTo(expected);
    }

}
