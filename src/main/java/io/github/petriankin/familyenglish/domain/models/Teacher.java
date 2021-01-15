package io.github.petriankin.familyenglish.domain.models;

import io.github.petriankin.familyenglish.domain.enums.Language;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "teachers")
public class Teacher {

    @Id
    private UUID id;

    private String firstName;
    private String middleName;
    private String lastName;

    private List<Language> languages;
}
