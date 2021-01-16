package io.github.petriankin.familyenglish.domain.service;


import io.github.petriankin.familyenglish.domain.models.Student;

import java.util.UUID;

public interface StudentService {
    Student create(Student dto);

    Student getById(UUID studentId);

    Student update(UUID studentId, Student dto);

    void delete(UUID studentId);
}
