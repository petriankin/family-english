package io.github.petriankin.familyenglish.domain.service.impl;

import io.github.petriankin.familyenglish.domain.models.Student;
import io.github.petriankin.familyenglish.domain.repository.StudentRepository;
import io.github.petriankin.familyenglish.domain.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getById(UUID studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found")); // TODO: 16.01.2021 custom ENFE
    }

    @Override
    public Student update(UUID studentId, Student dto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(UUID studentId) {
        studentRepository.deleteById(studentId);
    }
}
