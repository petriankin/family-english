package io.github.petriankin.familyenglish.api.controller;

import io.github.petriankin.familyenglish.api.dto.StudentDto;
import io.github.petriankin.familyenglish.domain.service.StudentService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@Api(tags = "students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentDto create(@RequestBody StudentDto dto) {
        return studentService.create(dto);
    }

    @GetMapping(path = "/{studentId}")
    public StudentDto getById(@PathVariable UUID studentId) {
        return studentService.getById(studentId);
    }

    @GetMapping
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @PutMapping(path = "/{studentId}")
    public StudentDto update(@PathVariable UUID studentId, @RequestBody StudentDto student) {
        return studentService.update(studentId, student);
    }

    @DeleteMapping(path = "/{studentId}")
    public void delete(@PathVariable UUID studentId) {
        studentService.delete(studentId);
    }
}
