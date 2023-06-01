package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonResponse {
    private Long id;
    private String LessonName;

    public LessonResponse(Long id, String lessonName) {
        this.id = id;
        LessonName = lessonName;
    }
}
