package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.*;

import java.util.List;

public interface LessonService {
    LessonResponse saveLesson(Long courseId,LessonRequest lessonRequest);
    LessonResponse getLessonById(Long id);
    List<LessonResponse> getAllLessons();
    LessonResponse updateLessonById(Long id, LessonRequest lessonRequest);
    SimpleResponse deleteLessonById(Long id);
}
