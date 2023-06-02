package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LessonRequest {
    private String LessonName;
    private String description;
}
