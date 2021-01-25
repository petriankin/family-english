package io.github.petriankin.familyenglish.domain.service.impl;

import io.github.petriankin.familyenglish.api.dto.StudentDto;
import io.github.petriankin.familyenglish.domain.exception.EntityNotFoundException;
import io.github.petriankin.familyenglish.domain.mapper.StudentMapper;
import io.github.petriankin.familyenglish.domain.models.Student;
import io.github.petriankin.familyenglish.domain.repository.StudentRepository;
import io.github.petriankin.familyenglish.domain.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDto create(StudentDto student) {
        Student savedStudent = studentRepository.save(studentMapper.toEntity(student));
        return studentMapper.toDto(savedStudent);
    }

    @Override
    public StudentDto getById(UUID studentId) {
        return studentRepository.findById(studentId)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    @Override
    public List<StudentDto> findAll() {
        return studentMapper.toDtos(studentRepository.findAll());
    }

    @Override
    public StudentDto update(UUID studentId, StudentDto dto) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        Student updatedStudent = studentMapper.updateFromDto(dto, foundStudent);

        return studentMapper.toDto(studentRepository.save(updatedStudent));
    }

    @Override
    public void delete(UUID studentId) {
        studentRepository.deleteById(studentId);
    }
}
