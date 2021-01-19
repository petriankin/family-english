package io.github.petriankin.familyenglish.domain.mapper;

import io.github.petriankin.familyenglish.api.dto.StudentDto;
import io.github.petriankin.familyenglish.domain.enums.EducationPlace;
import io.github.petriankin.familyenglish.domain.enums.EducationType;
import io.github.petriankin.familyenglish.domain.enums.StudentCategory;
import io.github.petriankin.familyenglish.domain.enums.StudentStatus;
import io.github.petriankin.familyenglish.domain.models.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class StudentMapperTest {

    public static final String STUDENT_ID = UUID.randomUUID().toString();
    public static final String STUDENT_FIRST_NAME = "John";
    public static final String STUDENT_MIDDLE_NAME = "Robert";
    public static final String STUDENT_LAST_NAME = "Doe";
    public static final LocalDate STUDENT_DOB = LocalDate.of(1989, 1, 29);
    public static final int STUDENT_AGE = 31;
    public static final String STUDENT_PHONE = "+7800999555";
    public static final String STUDENT_EMAIL = "mail@mail.com";
    public static final String STUDENT_CITY = "Moscow";
    public static final String STUDENT_ADDRESS = "Lenina";
    public static final List<String> STUDENT_SOCIAL_NETWORKS = Arrays.asList("Facebook", "Linkedin");
    public static final String STUDENT_ADDITIONAL_CONTACT = "mother";
    public static final String STUDENT_HEARD_ABOUT_US_FROM = "friend";
    public static final LocalDate STUDENT_FIRST_CONTACT_DATE = LocalDate.of(2019, 11, 22);
    public static final List<String> STUDENT_INTERESTS = Arrays.asList("chess", "vodka");
    public static final String STUDENT_COMMENTS = "some comments";
    public static final EducationType STUDENT_EDUCATION_TYPE = EducationType.INDIVIDUAL;
    public static final StudentCategory STUDENT_CATEGORY = StudentCategory.ADULT;
    public static final StudentStatus STUDENT_STATUS = StudentStatus.STUDYING;
    public static final EducationPlace STUDENT_EDUCATION_PLACE = EducationPlace.SCHOOL;

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(StudentMapper.class);
    }

    @Test
    void whetMapToEntityMapsCorrectly() {
        StudentDto studentDto = StudentDto.builder()
                .id(STUDENT_ID)
                .firstName(STUDENT_FIRST_NAME)
                .middleName(STUDENT_MIDDLE_NAME)
                .lastName(STUDENT_LAST_NAME)
                .dateOfBirth(STUDENT_DOB)
                .age(STUDENT_AGE)
                .primaryPhone(STUDENT_PHONE)
                .email(STUDENT_EMAIL)
                .city(STUDENT_CITY)
                .address(STUDENT_ADDRESS)
                .socialNetworkLinks(STUDENT_SOCIAL_NETWORKS)
                .additionalContact(STUDENT_ADDITIONAL_CONTACT)
                .heardAboutUsFrom(STUDENT_HEARD_ABOUT_US_FROM)
                .firstContactDate(STUDENT_FIRST_CONTACT_DATE)
                .interests(STUDENT_INTERESTS)
                .comments(STUDENT_COMMENTS)
                .educationType(STUDENT_EDUCATION_TYPE)
                .category(STUDENT_CATEGORY)
                .status(STUDENT_STATUS)
                .educationPlace(STUDENT_EDUCATION_PLACE)
                .build();

        Student student = mapper.toEntity(studentDto);

        Student expected = getEntity();

        Assertions.assertThat(student).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void whenMapToDtoMapsCorrectly() {
        Student entity = getEntity();

        StudentDto studentDto = mapper.toDto(entity);

        StudentDto expected = getDto();

        Assertions.assertThat(studentDto).usingRecursiveComparison().isEqualTo(expected);
    }

    private StudentDto getDto() {
        return StudentDto.builder()
                .id(STUDENT_ID)
                .firstName(STUDENT_FIRST_NAME)
                .middleName(STUDENT_MIDDLE_NAME)
                .lastName(STUDENT_LAST_NAME)
                .dateOfBirth(STUDENT_DOB)
                .age(STUDENT_AGE)
                .primaryPhone(STUDENT_PHONE)
                .email(STUDENT_EMAIL)
                .city(STUDENT_CITY)
                .address(STUDENT_ADDRESS)
                .socialNetworkLinks(STUDENT_SOCIAL_NETWORKS)
                .additionalContact(STUDENT_ADDITIONAL_CONTACT)
                .heardAboutUsFrom(STUDENT_HEARD_ABOUT_US_FROM)
                .firstContactDate(STUDENT_FIRST_CONTACT_DATE)
                .interests(STUDENT_INTERESTS)
                .comments(STUDENT_COMMENTS)
                .educationType(STUDENT_EDUCATION_TYPE)
                .category(STUDENT_CATEGORY)
                .status(STUDENT_STATUS)
                .educationPlace(STUDENT_EDUCATION_PLACE)
                .build();
    }

    private Student getEntity() {
        return Student.builder()
                .id(STUDENT_ID)
                .firstName(STUDENT_FIRST_NAME)
                .middleName(STUDENT_MIDDLE_NAME)
                .lastName(STUDENT_LAST_NAME)
                .dateOfBirth(STUDENT_DOB)
                .age(STUDENT_AGE)
                .primaryPhone(STUDENT_PHONE)
                .email(STUDENT_EMAIL)
                .city(STUDENT_CITY)
                .address(STUDENT_ADDRESS)
                .socialNetworkLinks(STUDENT_SOCIAL_NETWORKS)
                .additionalContact(STUDENT_ADDITIONAL_CONTACT)
                .heardAboutUsFrom(STUDENT_HEARD_ABOUT_US_FROM)
                .firstContactDate(STUDENT_FIRST_CONTACT_DATE)
                .interests(STUDENT_INTERESTS)
                .comments(STUDENT_COMMENTS)
                .educationType(STUDENT_EDUCATION_TYPE)
                .category(STUDENT_CATEGORY)
                .status(STUDENT_STATUS)
                .educationPlace(STUDENT_EDUCATION_PLACE)
                .build();
    }
}
