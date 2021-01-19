package io.github.petriankin.familyenglish.domain.mapper;

import io.github.petriankin.familyenglish.api.dto.StudentDto;
import io.github.petriankin.familyenglish.domain.models.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentDto dto);

    StudentDto toDto(Student entity);

    List<Student> toEntities(List<StudentDto> dtos);

    List<StudentDto> toDtos(List<Student> entities);
}
