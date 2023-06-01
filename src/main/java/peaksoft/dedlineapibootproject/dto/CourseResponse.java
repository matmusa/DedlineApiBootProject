package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor

public class CourseResponse {
    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private String description;
}
