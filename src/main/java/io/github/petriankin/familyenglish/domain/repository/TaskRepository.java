package io.github.petriankin.familyenglish.domain.repository;

import io.github.petriankin.familyenglish.domain.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends MongoRepository<Task, UUID> {
}
