package peaksoft.dedlineapibootproject.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.dedlineapibootproject.enums.Gender;
import peaksoft.dedlineapibootproject.enums.StudyFormat;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private StudyFormat studyFormat;
    private Gender gender;

    public StudentResponse(Long id,
                           String firstName,
                           String lastName,
                           String phoneNumber,
                           String email,
                           StudyFormat studyFormat,
                           Gender gender) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
        this.gender = gender;
    }
}

