package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class CourseRequest {

    private String courseName;
    private String description;

    public CourseRequest(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }
}
