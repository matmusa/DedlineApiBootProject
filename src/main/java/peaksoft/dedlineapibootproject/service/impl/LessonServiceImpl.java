package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.LessonRequest;
import peaksoft.dedlineapibootproject.dto.LessonResponse;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.entity.Lesson;
import peaksoft.dedlineapibootproject.repository.LessonRepository;
import peaksoft.dedlineapibootproject.service.LessonService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public LessonResponse saveLesson(LessonRequest lessonRequest) {
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        lessonRepository.save(lesson);
        return new LessonResponse(lesson.getId(),
                lesson.getLessonName());
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        Lesson lesson = new Lesson();
        lessonRepository.findLessonById(id).orElseThrow(()
                -> new NullPointerException("Lesson with id " + id + "  is not found "));

        return new LessonResponse(lesson.getId(),
                lesson.getLessonName());
    }

    @Override
    public List<LessonResponse> getAllLessons() {
        return lessonRepository.getAllLessons();
    }

    @Override
    public LessonResponse updateLessonById(Long id, LessonRequest lessonRequest) {
        Lesson lesson =
        lessonRepository.findLessonById(id).orElseThrow(()
                -> new NullPointerException("Lesson with id " + id + "  is not found "));
        lesson.setLessonName(lessonRequest.getLessonName());
        lessonRepository.save(lesson);
        return new LessonResponse(
                lesson.getId(),
                lesson.getLessonName());
    }

    @Override
    public SimpleResponse deleteLessonById(Long id) {
        boolean exist = lessonRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Lesson with id: " + id + " is not found");
        }
        lessonRepository.deleteById(id);
        return new SimpleResponse("DELETED","Lesson with id: " + id + " is deleted");

    }
    }

