package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
