package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class InstructorResponse {
    private Long id;
    private String  firstName;
    private String  lastName;
    private String  specialization;

    public InstructorResponse(String firstName) {
        this.firstName = firstName;
    }

    public InstructorResponse(Long id, String firstName, String lastName, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }
}
