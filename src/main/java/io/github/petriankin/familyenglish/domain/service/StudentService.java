package io.github.petriankin.familyenglish.domain.service;


import io.github.petriankin.familyenglish.api.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    StudentDto create(StudentDto dto);

    StudentDto getById(UUID studentId);

    List<StudentDto> findAll();

    StudentDto update(UUID studentId, StudentDto dto);

    void delete(UUID studentId);
}
