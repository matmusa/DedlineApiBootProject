package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InstructorResponse {
    private Long id;
    private String  firstName;
    private String  lastName;
    private String  specialization;
}
