package io.github.petriankin.familyenglish.domain.repository;

import io.github.petriankin.familyenglish.domain.models.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, UUID> {
}
