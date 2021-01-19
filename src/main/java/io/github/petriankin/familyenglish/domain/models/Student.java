package io.github.petriankin.familyenglish.domain.models;

import io.github.petriankin.familyenglish.domain.enums.EducationPlace;
import io.github.petriankin.familyenglish.domain.enums.EducationType;
import io.github.petriankin.familyenglish.domain.enums.StudentCategory;
import io.github.petriankin.familyenglish.domain.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @Id
    private String id;

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
    @Builder.Default
    private StudentStatus status = StudentStatus.POTENTIAL_CLIENT;
    private EducationPlace educationPlace;

}
