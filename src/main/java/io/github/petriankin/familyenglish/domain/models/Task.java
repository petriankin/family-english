package io.github.petriankin.familyenglish.domain.models;

import io.github.petriankin.familyenglish.domain.enums.TaskStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private UUID id;
    private String name;
    private String description;
    private TaskStatus status = TaskStatus.TODO;

}
