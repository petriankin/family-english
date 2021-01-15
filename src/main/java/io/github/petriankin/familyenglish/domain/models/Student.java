package io.github.petriankin.familyenglish.domain.models;

import io.github.petriankin.familyenglish.domain.enums.EducationPlace;
import io.github.petriankin.familyenglish.domain.enums.EducationType;
import io.github.petriankin.familyenglish.domain.enums.StudentCategory;
import io.github.petriankin.familyenglish.domain.enums.StudentStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "students")
public class Student {

    @Id
    private UUID id;

    private String firstName;
    private String middleName;
    private String lastName;

    private LocalDate dateOfBirth;
    private Integer age; // in case DOB is not known

    private String primaryPhone;
    private String email;
    private String city;
    private String address;
    private List<String> socialNetworkLinks;
    private String additionalContact;

    private String heardAboutUsFrom;
    private LocalDate firstContactDate;
    private List<String> interests;

    private String comments;

    private EducationType educationType;
    private StudentCategory category;
    private StudentStatus status = StudentStatus.POTENTIAL_CLIENT;
    private EducationPlace educationPlace;

}
