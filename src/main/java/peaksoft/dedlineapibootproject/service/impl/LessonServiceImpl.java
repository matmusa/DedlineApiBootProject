package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.LessonRequest;
import peaksoft.dedlineapibootproject.dto.LessonResponse;
import peaksoft.dedlineapibootproject.repository.LessonRepository;
import peaksoft.dedlineapibootproject.service.LessonService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public LessonResponse saveLesson(LessonRequest lessonRequest) {
        return null;
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        return null;
    }

    @Override
    public List<LessonResponse> getAllLessons() {
        return null;
    }

    @Override
    public LessonResponse updateLessonById(Long id, LessonRequest lessonRequest) {
        return null;
    }

    @Override
    public void deleteLessonById(Long id) {

    }
}
