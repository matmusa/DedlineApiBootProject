package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonResponse {
    private Long id;
    private String LessonName;
    private String description;

    public LessonResponse(Long id, String lessonName, String description) {
        this.id = id;
        LessonName = lessonName;
        this.description = description;
    }
}
